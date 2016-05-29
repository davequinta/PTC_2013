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
 * @author Todos
 */
public class MtoFamilia {
         String nombre;
    String detalle;
    DefaultTableModel modelo;
    
        public MtoFamilia()
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
            String sql = "insert into familia_plantas (Nombre_familia,Detalle_familia) values (?,?)";
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
            String sql = "UPDATE familia_plantas SET Nombre_familia = ?, Detalle_familia = ? "
            + "WHERE id_familia = ?;";
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
            String sql = "DELETE from familia_plantas  WHERE id_familia = ?;";
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
            String sql = "SELECT * From familia_plantas";
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
String sql = "select MAX(id_familia) from familia_plantas";
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
            String sql = "SELECT id_familia, Nombre_familia, Detalle_familia FROM familia_plantas  WHERE  (id_familia LIKE ? OR Nombre_familia LIKE ? OR  Detalle_familia LIKE ?  )";
            
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
                detalle= rs.getString(3);
             
                
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
