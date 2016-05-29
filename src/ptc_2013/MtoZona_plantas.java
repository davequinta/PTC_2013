/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class MtoZona_plantas {
    Connection cn;
   DefaultComboBoxModel modelo; 
   DefaultComboBoxModel modelo2; 
   
   
   DefaultTableModel modelo3;
   
   
   int correlativo_plantas;
   String nombre_planta;
   
   
   int Num_zona;
   String nombre_zona;
   
   
   String fecha;
   
   
      public MtoZona_plantas()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
   

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }

    public DefaultComboBoxModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultComboBoxModel modelo2) {
        this.modelo2 = modelo2;
    }

    public DefaultTableModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultTableModel modelo3) {
        this.modelo3 = modelo3;
    }

    public int getCorrelativo_plantas() {
        return correlativo_plantas;
    }

    public void setCorrelativo_plantas(int correlativo_plantas) {
        this.correlativo_plantas = correlativo_plantas;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public int getNum_zona() {
        return Num_zona;
    }

    public void setNum_zona(int Num_zona) {
        this.Num_zona = Num_zona;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
   
    public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into zona_plantas (correlativo_plantas, Num_zona, fecha) values (?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setInt(1,correlativo_plantas);
            cmd.setInt(2,Num_zona);
            cmd.setString(3,fecha);
          
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
    
    
    public boolean cargarDatosPlanta()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT correlativo_plantas, nombre_planta FROM plantas";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               correlativo_plantas = rs.getInt(1);
               nombre_planta = rs.getString(2);
               
               
               modelo.addElement(new Lista(correlativo_plantas, nombre_planta));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
    
      public boolean cargarDatosZonas()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT Num_zona, nombre_zona FROM zonas";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               Num_zona = rs.getInt(1);
               nombre_zona = rs.getString(2);
               
               
               modelo2.addElement(new Lista(Num_zona, nombre_zona));
               
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
           String sql = "SELECT dbo.plantas.nombre_planta, dbo.zonas.nombre_zona FROM            dbo.plantas INNER JOIN\n" +
"                         dbo.zona_plantas ON dbo.plantas.correlativo_plantas = dbo.zona_plantas.correlativo_plantas INNER JOIN\n" +
"                         dbo.zonas ON dbo.zona_plantas.Num_zona = dbo.zonas.Num_zona";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo3.getRowCount()>0)modelo3.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
              
               nombre_planta = rs.getString(1);
                nombre_zona = rs.getString(2);
                
               
                
                modelo3.addRow( new Object []{nombre_planta,nombre_zona});
               
            }
                      
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
   
   
}
