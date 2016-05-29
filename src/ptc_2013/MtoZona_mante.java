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
public class MtoZona_mante {
      Connection cn;
   DefaultComboBoxModel modelo; 
   DefaultComboBoxModel modelo2; 
 
   
   
   DefaultTableModel modelo3;
   
   
   int id_mantenimiento;
   String nombre_mante;

   
   
   int Num_zona;
   String nombre_zona;
   
   
   String fecha;
   
   
   
      public MtoZona_mante()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public String getNombre_mante() {
        return nombre_mante;
    }

    public void setNombre_mante(String nombre_mante) {
        this.nombre_mante = nombre_mante;
    }
      
      

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }

    public DefaultTableModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultTableModel modelo3) {
        this.modelo3 = modelo3;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
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

    public DefaultComboBoxModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultComboBoxModel modelo2) {
        this.modelo2 = modelo2;
    }
    
    
      
      
    public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into mante_zonas (id_mantenimiento, Num_zona, fecha) values (?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setInt(1,id_mantenimiento);
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
     
      public boolean cargarDatosMante()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT id_mantenimiento, nombre_mante FROM mantenimiento";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               id_mantenimiento = rs.getInt(1);
               nombre_mante = rs.getString(2);
               
               
               modelo.addElement(new Lista(id_mantenimiento, nombre_mante));
               
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
           String sql = "SELECT dbo.mantenimiento.nombre_mante, dbo.zonas.nombre_zona FROM     dbo.mante_zonas INNER JOIN\n" +
"                  dbo.mantenimiento ON dbo.mante_zonas.id_mantenimiento = dbo.mantenimiento.id_mantenimiento INNER JOIN\n" +
"                  dbo.zonas ON dbo.mante_zonas.Num_zona = dbo.zonas.Num_zona";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo3.getRowCount()>0)modelo3.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
              
             nombre_mante = rs.getString(1);
                nombre_zona = rs.getString(2);
                
               
                
                modelo3.addRow( new Object []{nombre_mante,nombre_zona});
               
            }
                      
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
   
   


   
}
