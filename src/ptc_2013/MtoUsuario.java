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
 * @author Todos
 */
public class MtoUsuario {

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public DefaultComboBoxModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultComboBoxModel modelo2) {
        this.modelo2 = modelo2;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      DefaultTableModel modelo;
      DefaultComboBoxModel modelo2; 
      
     Connection cn;
    int id;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
    String nick;
    String nombres;
    String apellidos;
    String contra;
    int codigo;
    String nombre;
    public MtoUsuario()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
      public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into usuarios ( id_tipo_usu, nombre_usuario, apellido_usu, contraseña ,nickname_usuario) values (?,?,?, dbo.FU_ENCRIPTA(?),?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            
            cmd.setInt(1,codigo);
            cmd.setString(2,nombres);
            cmd.setString(3,apellidos);
             cmd.setString(4,contra);
           cmd.setString(5,nick);
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
     
     public boolean cargarDatosCombo()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT * FROM tipo_usuario";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               codigo = rs.getInt(1);
               nombre = rs.getString(2);
               modelo2.addElement(new Lista(codigo, nombre));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
    
     
      public boolean  Modificar()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE usuarios SET nickname_usuario=?, id_tipo_usu = ?,  nombre_usuario=?, apellido_usu=?, contraseña=? "
            + "WHERE codigo_usuario = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            
            cmd.setString(1,nick);
            cmd.setInt(2,codigo);
            cmd.setString(3,nombres);
             cmd.setString(4,apellidos);
              cmd.setString(5,contra);
              
              cmd.setInt(6,id);
         
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
       public boolean  Eliminar()
  {
      boolean resp = false;
        try 
        {
            String sql = "DELETE from usuarios  WHERE codigo_usuario = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setInt(1,id);
            
             if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
  }
       
        public boolean  consultarTabla()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT codigo_usuario, nickname_usuario, nombre_tipo_usu, nombre_usuario, apellido_usu, contraseña FROM usuarios u , tipo_usuario t WHERE (u.id_tipo_usu = t.id_tipo_usu)" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id  = rs.getInt(1);
               nick = rs.getString(2);
               nombre= rs.getString(3);
               nombres = rs.getString(4);
              apellidos = rs.getString(5);
              contra = rs.getString(6);
             
             
                
                modelo.addRow( new Object []{id, nick, nombre, nombres, apellidos, contra});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
    }
        
public boolean codcargo()
{
boolean resp = false;
try{
String sql = "select MAX(codigo_usuario) from usuarios";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
id= rs.getInt(1);
}
id = id + 1;

// rs.next();
// fa_cod = rs.getInt("cod");
// resp = true;
// rs.close();
// CallableStatement fa = cn.prepareCall("{call select dbo.codigo()()}");
// fa.setInt(fa_cod);
// if (!fa.execute()){
// resp = true;
// }
cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
return resp;//To change body of generated methods, choose Tools | Templates.
}
    }

