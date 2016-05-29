/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

/**
 *
 * @author Carlos_Cornejo
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class MtoTipo_Producto {
    Connection cn;
    int id_tipo_producto;
    String nombre_producto;
    String detalle_tipo_producto;
    DefaultTableModel modelo;
     String Filtro;
     public MtoTipo_Producto()
    {
        Conexion con = new Conexion();
        cn= con.conectar();
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }

 

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDetalle_tipo_producto() {
        return detalle_tipo_producto;
    }

    public void setDetalle_tipo_producto(String detalle_tipo_producto) {
        this.detalle_tipo_producto = detalle_tipo_producto;
    }



    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
      public boolean codTipoProducto() {
       boolean resp = false;
        try{
        String sql = "select MAX(id_tipo_producto) from tipo_producto";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
id_tipo_producto = rs.getInt(1);
}
id_tipo_producto = id_tipo_producto + 1;

cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
        return false;
    }
    public boolean consultarTabla()
    {
        boolean resp = false;
        try 
        {
           String  sql ="SELECT id_tipo_producto, nombre_producto, detalle_tipo_producto "
                   + "FROM  tipo_producto  WHERE ( nombre_producto LIKE ? OR detalle_tipo_producto LIKE ? )";
           
           
           PreparedStatement cmd = cn.prepareStatement(sql);
             cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
          ResultSet rs = cmd.executeQuery();
          while(modelo.getRowCount()>0)modelo.removeRow(0);
          while(rs.next())
          {
              resp = true;
             id_tipo_producto = rs.getInt(1);
             nombre_producto = rs.getString(2);
             detalle_tipo_producto= rs.getString(3);
             modelo.addRow(new Object[]{id_tipo_producto,nombre_producto,detalle_tipo_producto});
              
          }
        }
 catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
}
    public boolean ConsultarTipoProductos()
    {
        boolean resp = false;
        try 
        {
         String sql =("SELECT id_tipo_producto, nombre_producto, detalle_tipo_producto "
                   + "FROM  tipo_producto");
         PreparedStatement cmd = cn.prepareStatement(sql);
         ResultSet rs = cmd.executeQuery();
            while(modelo.getRowCount()>0)modelo.removeRow(0);
         while(rs.next())
         {
             resp = true;
             id_tipo_producto= rs.getInt(1);
             nombre_producto= rs.getString(2);
             detalle_tipo_producto= rs.getString(3);
             modelo.addRow(new Object[]{id_tipo_producto,nombre_producto,detalle_tipo_producto});
         
         }
         cmd.close();
         cn.close();
        }
              catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
    } 
      public boolean AgregarTipo_Productos()
    {
        boolean resp = false;
        try 
        {
            String sql = " insert into tipo_producto(nombre_producto, detalle_tipo_producto)values (?,?)";
            // cuando se maneje la consulta
            PreparedStatement cmd = cn.prepareStatement(sql);
        
            cmd.setString(1, nombre_producto);
            cmd.setString(2, detalle_tipo_producto);
            
            if (!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            
        }
        catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
    }  
   
    public boolean modificarTipo_Producto()
    {
        boolean resp = false;
        try
        {
            String sql= "UPDATE tipo_producto SET nombre_producto= ?, detalle_tipo_producto= ?  "
                    + "WHERE id_tipo_producto = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
//llenar los parametros
           cmd.setInt(3,id_tipo_producto);
            cmd.setString(1, nombre_producto);
            cmd.setString(2, detalle_tipo_producto);
            //Si da error devuelve 1, caso contrario 0
             //tomen en cuenta el "!" de negación
                   if(!cmd.execute())
                    {
                       resp = true;
                     }
                    cmd.close();
                    cn.close();
        }
        catch (Exception e)
                
                {
                 System.out.println(e.toString());   
                }
        return resp;
    }
    public boolean eliminarTipo_Producto()
       {
           boolean resp = false;
           try
           {
               //Realizar consulta DELETE
                         String sql = "DELETE FROM tipo_producto WHERE id_tipo_producto = ?;"; 
                         PreparedStatement cmd = cn.prepareStatement(sql);
                         cmd.setInt(1, id_tipo_producto);
                         if(!cmd.execute())
                            {
                                 resp = true;
                            }
                                       cmd.close();
                                       cn.close();
           }
           catch (Exception e)
                
                {
                 System.out.println(e.toString());   
                }
        return resp;
                
       }
    
}
