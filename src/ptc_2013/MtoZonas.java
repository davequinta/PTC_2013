/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class MtoZonas {
     Connection cn;
     
     int num_zona;
     
     String nombre_zona;
     
     int id_clasi;
     String nombre_clasi;
     
     int capacidad;
     
     
    String Filtro;
    
    DefaultTableModel modelo;
    
     DefaultComboBoxModel modelo2;
     
     
      public MtoZonas()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getNum_zona() {
        return num_zona;
    }

    public void setNum_zona(int num_zona) {
        this.num_zona = num_zona;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    public int getId_clasi() {
        return id_clasi;
    }

    public void setId_clasi(int id_clasi) {
        this.id_clasi = id_clasi;
    }

    public String getNombre_clasi() {
        return nombre_clasi;
    }

    public void setNombre_clasi(String nombre_clasi) {
        this.nombre_clasi = nombre_clasi;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public DefaultComboBoxModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultComboBoxModel modelo2) {
        this.modelo2 = modelo2;
    }
      
      public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into zonas (nombre_zona, id_clasi, capacidad ) values (?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,nombre_zona);
            cmd.setInt(2,id_clasi);
            cmd.setInt(3,capacidad);
        
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
      
      
        public boolean cargarDatosCombo()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT * FROM clasificacion_zona";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               id_clasi = rs.getInt(1);
               nombre_clasi = rs.getString(2);
               modelo2.addElement(new Lista(id_clasi, nombre_clasi));
               
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
            String sql = "UPDATE zonas SET nombre_zona = ?,id_clasi=?,capacidad=?"
            + "WHERE Num_zona = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setString(1,nombre_zona);
            cmd.setInt(2,id_clasi);
            cmd.setInt(3,capacidad);
            cmd.setInt(4,num_zona);
           
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
            String sql = "DELETE from zonas  WHERE Num_zonas = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setInt(1,num_zona);
            
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
            String sql = "SELECT * From zonas" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               num_zona  = rs.getInt(1);
                nombre_zona = rs.getString(2);
                 id_clasi = rs.getInt(3);
                 capacidad = rs.getInt(4);
            
                
                modelo.addRow( new Object []{num_zona, nombre_zona, nombre_clasi,capacidad});
               
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
          String sql = "select MAX(Num_zona) from zonas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              num_zona = rs.getInt(1);
          }
          num_zona = num_zona + 1;
        

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
            String sql = "SELECT nombre_zona, id_clasi FROM zonas  WHERE  (nombre_zona LIKE ? OR id_clasi LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
     
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
               
                nombre_zona = rs.getString(1);
                nombre_clasi = rs.getString(2);
                
             
                
                modelo.addRow( new Object []{ nombre_zona, nombre_clasi});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
      
     
}
