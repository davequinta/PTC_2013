/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Carlos_Cornejo
 */
public class MtoGrupo {
    Connection cn;
      public MtoGrupo()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
     int ninos;
     int adultos;
     int ancianos;
     int visita = 0;

    public void setVisita(int visita) {
        this.visita = visita;
    }

    public int getVisita() {
        return visita;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public int getNinos() {
        return ninos;
    }

    public void setNinos(int ninos) {
        this.ninos = ninos;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public int getAncianos() {
        return ancianos;
    }

    public void setAncianos(int ancianos) {
        this.ancianos = ancianos;
    }
     public boolean  guadarGrupo()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into visitas_grupo ( ninos, adultos, ancianos) values (?,?,?)";
            //Comando que maneje la 
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            
            cmd.setInt(1,ninos);
            cmd.setInt(2,adultos);
            cmd.setInt(3,ancianos);
          
            
            if(!cmd.execute())
            {
                resp = true;
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    public boolean codvis()
{
boolean resp = false;
try{
String sql = "select MAX(visita) from visitas_grupo";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
visita= rs.getInt(1);
}
visita= visita + 1;

cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
return resp;//To change body of generated methods, choose Tools | Templates.
}
}
