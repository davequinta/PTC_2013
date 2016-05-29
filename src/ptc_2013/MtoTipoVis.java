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
public class MtoTipoVis {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getDesc() {
        return desc;
    }

    public void setDesc(Double desc) {
        this.desc = desc;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    int id;
    String nombre;
    String detalle;
    Double desc;
   DefaultTableModel modelo;
   Connection cn;
   
   
   
   
   
    public MtoTipoVis()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
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
            String sql = "insert into tipo_visitante (nombre_tipo_vis,detalle_tipo_visitantes,descuento) values (?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
           
            cmd.setString(1,nombre);
            cmd.setString(2,detalle);
            cmd.setDouble(3,desc);
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
            String sql = "UPDATE tipo_visitante SET nombre_tipo_vis = ?, detalle_tipo_visitantes = ? ,descuento= ? "
            + "WHERE id_tipo_visitante = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           
            cmd.setInt(4, id);  
            cmd.setString(1,nombre);
            cmd.setString(2,detalle);
            cmd.setDouble(3,desc);
         
         
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
            String sql = "DELETE from tipo_visitante  WHERE id_tipo_visitante = ?;";
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
            String sql = "SELECT * From tipo_visitante";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id  = rs.getInt(1);
                nombre = rs.getString(2);
                 detalle = rs.getString(3);
              desc = rs.getDouble(4);
                
                modelo.addRow( new Object []{id, nombre, detalle,desc});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
        
       public boolean codvis() {
boolean resp = false;
try{
String sql = "select MAX(id_tipo_visitante) from tipo_visitante";
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
        
//       public boolean  consultarFiltro()
//    {
//        boolean resp = false;
//        try 
//        {
//            String sql = "SELECT id_tipo_visitante, nombre_tipo_vis, detalle_tipo_visitantes, descuento FROM tipo_visitantes  WHERE  (id_region LIKE ? OR Nombre_region LIKE ? OR  Detalle_region LIKE ?  )";
//            
//            PreparedStatement cmd= cn.prepareStatement(sql); 
//            
//            
//            cmd.setString(1,"%"+Filtro+"%");
//            cmd.setString(2,"%"+Filtro+"%");
//            cmd.setString(3,"%"+Filtro+"%");
//             cmd.setString(4,"%"+Filtro+"%");
//           
//           
//           
//            ResultSet rs = cmd.executeQuery();
//            
//            while(modelo.getRowCount()>0)modelo.removeRow(0);
//                           
//            while(rs.next())
//            {
//               resp = true;
//               
//                id_region = rs.getInt(1);
//                nombre_region = rs.getString(2);
//                detalle_region = rs.getString(3);
//             
//                
//                modelo.addRow( new Object []{id_region, nombre_region, detalle_region});
//               
//            }
//                    
//            
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Error: "+ex.getMessage());
//        }
//        return resp;
//        
//    }  
//       
//       
       
       
       
    
}
