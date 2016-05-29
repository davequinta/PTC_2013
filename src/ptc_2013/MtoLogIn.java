package ptc_2013;
import java.sql.*;
public class MtoLogIn {
    Connection cn;
    String usua;
    String pass;
    int nivel;
    
   
       
    public MtoLogIn()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

   

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUsua() {
        return usua;
    }

    public void setUsua(String usua) {
        this.usua = usua;
    }
    
    public boolean all_act()
    {
        boolean resp = false;
        try
        {
            String sql = "SELECT id_tipo_usu FROM usuarios WHERE nickname_usuario = ? and dbo.FU_DESENCRIPTA(contraseña) = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, usua);
            cmd.setString(2, pass);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = true;
                nivel = rs.getInt(1);
            }
        }
        catch(Exception error)
        {
            System.out.println(error.toString());
        }
        return resp;
    }
}
