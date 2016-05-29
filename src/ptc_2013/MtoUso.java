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
public class MtoUso {
    Connection cn;
    int id_uso;
    String nombre_uso;
    String detalle_uso;
    DefaultTableModel modelo;
    
    String Filtro;
    
     public MtoUso()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getId_uso() {
        return id_uso;
    }

    public void setId_uso(int id_uso) {
        this.id_uso = id_uso;
    }

    public String getNombre_uso() {
        return nombre_uso;
    }

    public void setNombre_uso(String nombre_uso) {
        this.nombre_uso = nombre_uso;
    }

    public String getDetalle_uso() {
        return detalle_uso;
    }

    public void setDetalle_uso(String detalle_uso) {
        this.detalle_uso = detalle_uso;
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
            String sql = "insert into uso_plantas(nombre_uso, detalle_uso) values ( ?, ?)";
            //Comando que maneje la conexion
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_uso);         
            cmd.setString(2,detalle_uso);
         
            
            
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
            String sql = "UPDATE uso_plantas SET nombre_uso = ?, detalle_uso = ? "
            + "WHERE id_uso = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setInt(3,id_uso);
            cmd.setString(1,nombre_uso);
            cmd.setString(2,detalle_uso);
            
            
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
            String sql = "DELETE FROM uso_plantas WHERE id_uso = ?;";
            PreparedStatement cmd = cn.prepareStatement(sql);
            //llenar los parametros
           
           cmd.setInt(1, id_uso);
            
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
           String sql = "SELECT * From uso_plantas";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                id_uso  = rs.getInt(1);
                nombre_uso = rs.getString(2);
                detalle_uso = rs.getString(3);
                
               
                
                modelo.addRow( new Object []{id_uso,nombre_uso,detalle_uso});
               
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
          String sql = "select MAX(id_uso) from uso_plantas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              id_uso= rs.getInt(1);
          }
          id_uso = id_uso + 1;

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
            String sql = "SELECT id_uso, Nombre_uso, Detalle_uso FROM uso_plantas  WHERE  (id_uso LIKE ? OR Nombre_uso LIKE ? OR  Detalle_uso LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
            cmd.setString(3,"%"+Filtro+"%");
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
                id_uso = rs.getInt(1);
                nombre_uso = rs.getString(2);
                detalle_uso = rs.getString(3);
             
                
                modelo.addRow( new Object []{id_uso, nombre_uso, detalle_uso});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    
    
    
}
