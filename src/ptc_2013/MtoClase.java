/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

/**
 *
 * @author David
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class MtoClase {
    Connection cn;
    int id_clase;
    String nombre_clase;
    String detalle_clase;
    DefaultTableModel modelo;
    
    String Filtro;
    
    public MtoClase()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getNombre_clase() {
        return nombre_clase;
    }

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public String getDetalle_clase() {
        return detalle_clase;
    }

    public void setDetalle_clase(String detalle_clase) {
        this.detalle_clase = detalle_clase;
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
    
    
         
    
   //Metodo que agrega los datos
    public boolean  agregaRegion()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into clase_plantas(nombre_clase, detalle_clase) values ( ?, ?)";
            //Comando que maneje la conexion
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_clase);         
            cmd.setString(2,detalle_clase);
         
            
            
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
     //Método que modifica los datos
    public boolean  modificarHotel()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE clase_plantas SET nombre_clase = ?, detalle_clase = ? "
            + "WHERE id_clase = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setInt(3,id_clase);
            cmd.setString(1,nombre_clase);
            cmd.setString(2,detalle_clase);
            
            
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
    //Método eliminar cliente
    public boolean  eliminarHotel()
    {
        boolean resp = false;
        try 
        {
           //Realizar consulta DELETE
            String sql = "DELETE FROM clase_plantas WHERE id_clase = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //llenar los parametros
           
           cmd.setInt(1, id_clase);
            
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
    
    public boolean  consultarTabla()
    {
        boolean resp = false;
        try 
        {
           String sql = "SELECT * From clase_plantas";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                id_clase  = rs.getInt(1);
                nombre_clase = rs.getString(2);
                detalle_clase = rs.getString(3);
                
               
                
                modelo.addRow( new Object []{id_clase,nombre_clase,detalle_clase});
               
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
          String sql = "select MAX(id_clase) from clase_plantas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              id_clase = rs.getInt(1);
          }
          id_clase = id_clase + 1;

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;
    }
    
      
      public boolean  consultarFiltro()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT id_clase, Nombre_clase, Detalle_clase FROM clase_plantas  WHERE  (id_clase LIKE ? OR Nombre_clase LIKE ? OR  Detalle_clase LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id_clase = rs.getInt(1);
                nombre_clase = rs.getString(2);
                detalle_clase = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_clase, nombre_clase, detalle_clase});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    
    
    
    
}
