/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class MtoCargoemple {

    
    
       String nombre;
    String detalle;
    DefaultTableModel modelo;
    
        public MtoCargoemple()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    Connection cn;
    int id;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }
    
    
    String Filtro;

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }
    
    
    
    
    
    
    
    public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            //Crear base de datos 
            String sql = "insert into cargo_empleado (Nombre_cargo,Detalle_cargo) values (?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
           
            cmd.setString(1,nombre);
            cmd.setString(2,detalle);
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
    
     public boolean  Modificar()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE cargo_empleado SET Nombre_cargo = ?, Detalle_cargo = ? "
            + "WHERE Id_cargo = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
               cmd.setInt(3,id);
            cmd.setString(1,nombre);
            cmd.setString(2,detalle);
         
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
            String sql = "DELETE from cargo_empleado  WHERE Id_cargo = ?;";
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
            String sql = "SELECT * From cargo_empleado";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id  = rs.getInt(1);
                nombre = rs.getString(2);
                 detalle = rs.getString(3);
             
                
                modelo.addRow( new Object []{id, nombre, detalle});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
        
       public boolean codcargo() {
boolean resp = false;
try{
String sql = "select MAX(Id_cargo) from cargo_empleado";
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
       
       
        public boolean  consultarFiltro()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT id_cargo, Nombre_cargo, Detalle_cargo FROM cargo_empleado  WHERE  (id_cargo LIKE ? OR Nombre_cargo LIKE ? OR  Detalle_cargo LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id = rs.getInt(1);
                nombre = rs.getString(2);
                detalle = rs.getString(3);
             
                
                modelo.addRow( new Object []{id, nombre, detalle});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
     
       
       
       
       
       
       
       
        
}
