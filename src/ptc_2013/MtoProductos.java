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
import javax.swing.DefaultComboBoxModel;
public class MtoProductos {
    Connection cn;
      DefaultComboBoxModel model; 
    int codigo_producto;
    Double precio_producto;
    String nombre_producto;
    String detalle_producto;
    int id_tipo_producto;
    int existencia_prod;
    DefaultTableModel Tabla;
    String Filtro;
  String nomb;
   String nombre;

    
   int exishuy;
   
   
   
    public MtoProductos()
    {
        Conexion con = new Conexion();
        cn= con.conectar();
    }

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }

    public int getExistencia_prod() {
        return existencia_prod;
    }

    public void setExistencia_prod(int existencia_prod) {
        this.existencia_prod = existencia_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public DefaultTableModel getTabla() {
        return Tabla;
    }

    public void setTabla(DefaultTableModel Tabla) {
        this.Tabla = Tabla;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DefaultComboBoxModel getModel() {
        return model;
    }

    public void setModel(DefaultComboBoxModel model) {
        this.model = model;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public Double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(Double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDetalle_producto() {
        return detalle_producto;
    }

    public int getExishuy() {
        return exishuy;
    }

    public void setExishuy(int exishuy) {
        this.exishuy = exishuy;
    }
    
    
    
    

    public void setDetalle_producto(String detalle_producto) {
        this.detalle_producto = detalle_producto;
    }

    public int getId_tipo_producto() {
        return id_tipo_producto;
    }

    public void setId_tipo_producto(int id_tipo_producto) {
        this.id_tipo_producto = id_tipo_producto;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }


   
    public boolean consultarTabla()
    {
        boolean resp = false;
        try 
        {
          String sql = "SELECT codigo_producto ,nombre_producto, nombre_producto ,detalle_producto, precio_producto, existencia_producto "
                  + "FROM  producto p, tipo_producto t "
                  + "WHERE( t.id_tipo_producto = p.id_tipo_producto) AND ( nombre_producto LIKE ? OR nombre_producto LIKE ? OR detalle_producto LIKE ? )";
           
          PreparedStatement cmd = cn.prepareStatement(sql);
               cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
          ResultSet rs = cmd.executeQuery();
          while(Tabla.getRowCount()>0)Tabla.removeRow(0);
          while(rs.next())
          {
              resp = true;
              
             codigo_producto= rs.getInt(1);
//             id_tipo_producto = rs.getInt(2);
             nombre_producto= rs.getString(3);
             nomb= rs.getString(2);
             detalle_producto= rs.getString(4);
             precio_producto= rs.getDouble(5);
             existencia_prod = rs.getInt(6);
             Tabla.addRow(new Object[]{codigo_producto,id_tipo_producto,nomb,nombre_producto,detalle_producto,precio_producto,existencia_prod});
              
          }
        }
 catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
}
    
     public boolean ConsultarProductos()
    {
        boolean resp = false;
        try 
        {
         String sql =("Select * from productos where codigo_producto =?");
         PreparedStatement cmd = cn.prepareStatement(sql);
         cmd.setInt(1,codigo_producto);
         ResultSet rs = cmd.executeQuery();
         if(rs.next())
         {
             resp = true;
         codigo_producto= rs.getInt(1);
            nombre = rs.getString(2);
             nombre_producto= rs.getString(3);
             detalle_producto= rs.getString(4);
             precio_producto= rs.getDouble(5);
             existencia_prod = rs.getInt(6);
          
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
     
     public boolean ConsultarHuy()
    {
        boolean resp = false;
        try 
        {
         String sql =("Select * from productos");
         PreparedStatement cmd = cn.prepareStatement(sql);
         cmd.setInt(1,codigo_producto);
         ResultSet rs = cmd.executeQuery();
         if(rs.next())
         {
             resp = true;
         codigo_producto= rs.getInt(1);
            nombre = rs.getString(2);
             nombre_producto= rs.getString(3);
             detalle_producto= rs.getString(4);
             precio_producto= rs.getDouble(5);
             existencia_prod = rs.getInt(6);
          
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
     
     
    public boolean cargarDatosComboBox()
{
    boolean resp = false;
    try
    {
        String  sql =" Select * from tipo_producto";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();
        while(rs.next())
        {
            resp = true;
            id_tipo_producto = rs.getInt(1);
            nombre = rs.getString(2);
            model.addElement(new Lista (id_tipo_producto, nombre));
        }
    }
    catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;

}
     public boolean AgregarProductos()
    {
        boolean resp = false;
        try 
        {
            String sql = " insert into productos (id_tipo_producto, nombre_producto, detalle_producto, precio_producto, existencia_producto)values (?,?,?,?,?)";
            // cuando se maneje la consulta
            PreparedStatement cmd = cn.prepareStatement(sql);
          
            cmd.setString(1,nombre);
            
            cmd.setString(2, nombre_producto);
            cmd.setString(3,detalle_producto);
            cmd.setDouble(4,precio_producto);
            cmd.setInt(5, existencia_prod);
            
            
            
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
  
    public boolean modificarproducto()
    {
        boolean resp = false;
        try
        {
            String sql= "UPDATE productos SET precio_producto= ?, nombre_producto= ?,"
                    + " detalle_producto= ?, id_tipo_producto= ?, existencia_producto = ?  "
                    + "WHERE codigo_producto = ?";
            
            
            PreparedStatement cmd = cn.prepareStatement(sql);
//llenar los parametro
            
             
              cmd.setInt(5,id_tipo_producto);
            
            cmd.setString(1, nombre_producto);
            cmd.setString(2,detalle_producto);
            cmd.setDouble(3,precio_producto);
            cmd.setInt(4, existencia_prod);
            
            
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
    public boolean eliminarProducto()
       {
           boolean resp = false;
           try
           {
               //Realizar consulta DELETE
                         String sql = "DELETE FROM productos WHERE codigo_producto = ?;"; 
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
    
    public boolean codProducto() {
       boolean resp = false;
        try{
        String sql = "select MAX(codigo_producto) from productos";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
codigo_producto = rs.getInt(1);
}
codigo_producto = codigo_producto + 1;

cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
        return false;
    }
    
    
    
     
          public boolean Stock()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT existencia_producto From productos WHERE codigo_producto = ?;";
            PreparedStatement cmd= cn.prepareStatement(sql);
            
            cmd.setInt(1,codigo_producto);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = true;
                existencia_prod = rs.getInt(1);
                
                
                
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
    
    
    
           public boolean actExi() {
        boolean resp = false;
        try{
          String sql = "UPDATE productos SET existencia_productos = ? + ? "
            + "WHERE codigo_producto = ? ;";
          CallableStatement cmd = cn.prepareCall(sql);
          
          
          
          cmd.setInt(1, existencia_prod ); 
          
          cmd.setInt(2, exishuy); 
             
             
         cmd.setInt(3, codigo_producto);
         
          
             if(!cmd.execute())
            {
                resp = true;
            }
         

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;
    }
        
          
          
          
    
}
    

