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
public class MtoGenero {
    Connection cn;
    int id_genero;
    String nombre_genero;
    String detalle_genero;
    DefaultTableModel modelo;
    
    String Filtro;
    
    
    public MtoGenero()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public String getDetalle_genero() {
        return detalle_genero;
    }

    public void setDetalle_genero(String detalle_genero) {
        this.detalle_genero = detalle_genero;
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
            String sql = "insert into genero_plantas(nombre_genero, detalle_genero) values ( ?, ?)";
            //Comando que maneje la conexion
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_genero);         
            cmd.setString(2,detalle_genero);
         
            
            
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
            String sql = "UPDATE genero_plantas SET nombre_genero = ?, detalle_genero = ? "
            + "WHERE id_genero = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setString(1,nombre_genero);
            cmd.setString(2,detalle_genero);
            cmd.setInt(3, id_genero);
            
            
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
            String sql = "DELETE FROM genero_plantas WHERE id_genero = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //llenar los parametros
           
           cmd.setInt(1, id_genero);
            
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
           String sql = "SELECT * From genero_plantas";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                id_genero  = rs.getInt(1);
                nombre_genero = rs.getString(2);
                detalle_genero = rs.getString(3);
                
               
                
                modelo.addRow( new Object []{id_genero,nombre_genero,detalle_genero});
               
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
          String sql = "select MAX(id_genero) from genero_plantas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              id_genero = rs.getInt(1);
          }
          id_genero = id_genero + 1;

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
            String sql = "SELECT id_genero, Nombre_genero, Detalle_genero FROM region_plantas  WHERE  (id_region LIKE ? OR Nombre_region LIKE ? OR  Detalle_region LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id_genero = rs.getInt(1);
                nombre_genero = rs.getString(2);
                detalle_genero = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_genero, nombre_genero, detalle_genero});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    
    
}
