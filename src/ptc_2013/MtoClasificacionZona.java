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
 * @author Toshiba
 */
public class MtoClasificacionZona {
    int id_clasi;
    Connection cn;
    
      public MtoClasificacionZona()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    
    
    
    public DefaultTableModel getModelo() {
        return modelo;
    }
    public void setModelo(DefaultTableModel modelo2) {
        this.modelo = modelo;
    }
    DefaultTableModel modelo;
   
   
   String nombre;
   String detalle;
   
 

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getId_clasi() {
        return id_clasi;
    }

    public void setId_clasi(int id_clasi) {
        this.id_clasi = id_clasi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
   public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into clasificacion_zona (nombre_clasi_zonas, detalle_clasi_zonas) values (?,?)";
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
            String sql = "UPDATE clasificacion_zona SET nombre_clasi_zonas = ?,detalle_clasi_zonas"
            + "WHERE id_clasi = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
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
            String sql = "DELETE from clasificacion_zona  WHERE id_clasi = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setInt(1,id_clasi);
            
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
            String sql = "SELECT * From clasificacion_zona" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id_clasi  = rs.getInt(1);
                nombre = rs.getString(2);
                 detalle = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_clasi, nombre, detalle});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
   
   
   public boolean codFact() {
        boolean resp = false;
        try{
          String sql = "select MAX(id_clasi) from clasificacion_zona";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              id_clasi = rs.getInt(1);
          }
          id_clasi = id_clasi + 1;

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;
    }
    
   
   
   
}
