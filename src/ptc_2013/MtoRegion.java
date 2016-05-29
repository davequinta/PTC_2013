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

public class MtoRegion {
    Connection cn;
    int id_region;
    String nombre_region;
    String detalle_region;
    
        String Filtro;
    
    DefaultTableModel modelo;
    
     public MtoRegion()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    public String getDetalle_region() {
        return detalle_region;
    }

    public void setDetalle_region(String detalle_region) {
        this.detalle_region = detalle_region;
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
            String sql = "insert into region_plantas(nombre_region, detalle_region) values ( ?, ?)";
            //Comando que maneje la conexion
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_region);         
            cmd.setString(2,detalle_region);
         
            
            
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
    public boolean  Modificar()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE region_plantas SET nombre_region = ?, detalle_region = ? "
            + "WHERE id_region = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setInt(3,id_region);
            cmd.setString(1,nombre_region);
            cmd.setString(2,detalle_region);
            
            
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
    public boolean  Eliminar()
    {
        boolean resp = false;
        try 
        {
           //Realizar consulta DELETE
            String sql = "DELETE FROM region_plantas WHERE id_region = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //llenar los parametros
           
           cmd.setInt(1, id_region);
            
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
           String sql = "SELECT * From region_plantas";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                id_region  = rs.getInt(1);
                nombre_region = rs.getString(2);
                detalle_region = rs.getString(3);
                
               
                
                modelo.addRow( new Object []{id_region,nombre_region,detalle_region});
               
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
          String sql = "select MAX(id_region) from region_plantas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              id_region = rs.getInt(1);
          }
          id_region = id_region + 1;
        

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
            String sql = "SELECT id_region, Nombre_region, Detalle_region FROM region_plantas  WHERE  (id_region LIKE ? OR Nombre_region LIKE ? OR  Detalle_region LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id_region = rs.getInt(1);
                nombre_region = rs.getString(2);
                detalle_region = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_region, nombre_region, detalle_region});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
     
      
      

}
