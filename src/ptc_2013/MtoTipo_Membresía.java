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
public class MtoTipo_Membresía {
    Connection cn;
    int id_tipo;
    String nombre_m;
    String detalle_tipo_m;
    Double costo;
    DefaultTableModel modelo;
     String Filtro;
     public MtoTipo_Membresía()
    {
        Conexion con = new Conexion();
        cn= con.conectar();
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_m() {
        return nombre_m;
    }

    public void setNombre_m(String nombre_m) {
        this.nombre_m = nombre_m;
    }

    public String getDetalle_tipo_m() {
        return detalle_tipo_m;
    }

    public void setDetalle_tipo_m(String detalle_tipo_m) {
        this.detalle_tipo_m = detalle_tipo_m;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }
     public boolean codTipoProducto() {
       boolean resp = false;
        try{
        String sql = "select MAX(id_tipo_membresia) from tipo_membresia";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
id_tipo = rs.getInt(1);
}
id_tipo = id_tipo + 1;

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
           String  sql ="SELECT  id_tipo_membresia,nombre_membre, detalle_tipo_membresia, costo_membresia "
                   + "FROM  tipo_membresia  WHERE ( nombre_membre LIKE ? OR detalle_tipo_membresia LIKE ? )";
           
           
           PreparedStatement cmd = cn.prepareStatement(sql);
             cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            
          ResultSet rs = cmd.executeQuery();
          while(modelo.getRowCount()>0)modelo.removeRow(0);
          while(rs.next())
          {
              resp = true;
             id_tipo = rs.getInt(1);
             nombre_m = rs.getString(2);
             detalle_tipo_m= rs.getString(3);
             costo = rs.getDouble(4);
             modelo.addRow(new Object[]{id_tipo,nombre_m,detalle_tipo_m,costo});
              
          }
        }
 catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
}
    public boolean ConsultarTipo()
    {
        boolean resp = false;
        try 
        {
         String sql =("SELECT  id_tipo_membresia,nombre_membre, detalle_tipo_membresia, costo_membresia "
                   + "FROM  tipo_membresia");
         PreparedStatement cmd = cn.prepareStatement(sql);
         
         ResultSet rs = cmd.executeQuery();
             while(modelo.getRowCount()>0)modelo.removeRow(0);
         while(rs.next())
         {
             resp = true;
             id_tipo= rs.getInt(1);
            nombre_m = rs.getString(2);
             detalle_tipo_m= rs.getString(3);
            costo= rs.getDouble(4);
            modelo.addRow(new Object[]{id_tipo,nombre_m,detalle_tipo_m,costo});
           
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
     public boolean AgregarTipo_M()
    {
        boolean resp = false;
        try 
        {
            String sql = " insert into tipo_membresia(nombre_membre, detalle_tipo_membresia, costo_membresia)values (?,?,?)";
            // cuando se maneje la consulta
            PreparedStatement cmd = cn.prepareStatement(sql);
        
            cmd.setString(1, nombre_m);
            cmd.setString(2, detalle_tipo_m);
            cmd.setDouble(3, costo);
            
            
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
   
    public boolean modificarTipo_m()
    {
        boolean resp = false;
        try
        {
            String sql= "UPDATE tipo_membresia SET nombre_membre= ?, detalle_tipo_membresia= ?, costo_membresia= ?  WHERE id_tipo_membresia = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
//llenar los parametros
           cmd.setInt(4,id_tipo);
            cmd.setString(1, nombre_m);
            cmd.setString(2, detalle_tipo_m);
            cmd.setDouble(3,costo);
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
    public boolean eliminarTipo_m()
       {
           boolean resp = false;
           try
           {
               //Realizar consulta DELETE
                         String sql = "DELETE FROM tipo_membresia WHERE id_tipo_membresia = ?;"; 
                         PreparedStatement cmd = cn.prepareStatement(sql);
                         cmd.setInt(1,id_tipo );
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
