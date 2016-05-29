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

public class MtoTipo {
    Connection cn;
    int id_tipo;
    String nombre_tipo;
    String detalle_tipo;
    DefaultTableModel modelo;
    
     public MtoTipo()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getDetalle_tipo() {
        return detalle_tipo;
    }

    public void setDetalle_tipo(String detalle_tipo) {
        this.detalle_tipo = detalle_tipo;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    String Filtro;

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }
    
    
    
    

      
    
   //Metodo que agrega los datos
    public boolean  agregarTipo()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into tipo_plantas(nombre_tipo, detalle_tipo) values ( ?, ?)";
            //Comando que maneje la conexion
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_tipo);         
            cmd.setString(2,detalle_tipo);
         
            
            
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
            String sql = "UPDATE tipo_plantas SET nombre_tipo = ?, detalle_tipo = ? "
            + "WHERE id_tipo = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
            
            cmd.setInt(3, id_tipo);
            cmd.setString(1,nombre_tipo);
            cmd.setString(2,detalle_tipo);
            
            
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
            String sql = "DELETE FROM tipo_plantas WHERE id_tipo = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //llenar los parametros
           
           cmd.setInt(1, id_tipo);
            
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
           String sql = "SELECT * From tipo_plantas";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                id_tipo  = rs.getInt(1);
                nombre_tipo = rs.getString(2);
                detalle_tipo = rs.getString(3);
                
               
                
                modelo.addRow( new Object []{id_tipo,nombre_tipo,detalle_tipo});
               
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
          String sql = "select MAX(id_tipo) from tipo_plantas";
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
        return resp;//To change body of generated methods, choose Tools | Templates.
    }
    
    
     
      public boolean  consultarFiltro()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT id_tipo, Nombre_tipo, Detalle_tipo FROM tipo_plantas  WHERE  (id_tipo LIKE ? OR Nombre_tipo LIKE ? OR  Detalle_tipo LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id_tipo = rs.getInt(1);
                nombre_tipo = rs.getString(2);
                detalle_tipo = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_tipo, nombre_tipo, detalle_tipo});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    
    
}
