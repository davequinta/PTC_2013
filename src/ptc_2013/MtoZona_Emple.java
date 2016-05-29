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
public class MtoZona_Emple {
   Connection cn;
   DefaultComboBoxModel modelo; 
   DefaultComboBoxModel modelo2; 
   
   
   String DUI_empleado;
   String Nombre_empleado;
   
   
   int Num_zona;
   String nombre_zona;
   
   String Fecha;

     DefaultTableModel modelo3;
     
     
       DefaultComboBoxModel modeloDesde; 
    DefaultComboBoxModel modeloHasta; 
    
    
    String horario;
    String horario_hasta;
   
      public MtoZona_Emple()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public DefaultTableModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultTableModel modelo3) {
        this.modelo3 = modelo3;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario_hasta() {
        return horario_hasta;
    }

    public void setHorario_hasta(String horario_hasta) {
        this.horario_hasta = horario_hasta;
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

    public String getDUI_empleado() {
        return DUI_empleado;
    }

    public void setDUI_empleado(String DUI_empleado) {
        this.DUI_empleado = DUI_empleado;
    }

    public String getNombre_empleado() {
        return Nombre_empleado;
    }

    public void setNombre_empleado(String Nombre_empleado) {
        this.Nombre_empleado = Nombre_empleado;
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
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public DefaultComboBoxModel getModeloDesde() {
        return modeloDesde;
    }

    public void setModeloDesde(DefaultComboBoxModel modeloDesde) {
        this.modeloDesde = modeloDesde;
    }

    public DefaultComboBoxModel getModeloHasta() {
        return modeloHasta;
    }

    public void setModeloHasta(DefaultComboBoxModel modeloHasta) {
        this.modeloHasta = modeloHasta;
    }
    
    
    
   
    public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into zona_empleados (DUI_empleado, Num_zona, fecha, horario, horario_hasta) values (?,?,?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,DUI_empleado);
            cmd.setInt(2,Num_zona);
            cmd.setString(3,Fecha);
            
            cmd.setString(4,horario);
            
            cmd.setString(5,horario_hasta);
            
          
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
    
    
    public boolean cargarDatosEmpleado()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT DUI_empleado, nombres_empleado FROM Empleados";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               DUI_empleado = rs.getString(1);
               Nombre_empleado = rs.getString(2);
               
               
               modelo.addElement(new Lista(DUI_empleado, Nombre_empleado));
               
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
           String sql = "SELECT        dbo.Empleados.nombres_empleado, dbo.zonas.nombre_zona FROM  dbo.Empleados INNER JOIN dbo.zona_empleados ON dbo.Empleados.DUI_empleado = dbo.zona_empleados.DUI_empleado INNER JOIN dbo.zonas ON dbo.zona_empleados.Num_zona = dbo.zonas.Num_zona";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo3.getRowCount()>0)modelo3.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
              
               Nombre_empleado = rs.getString(1);
                nombre_zona = rs.getString(2);
                
               
                
                modelo3.addRow( new Object []{Nombre_empleado,nombre_zona});
               
            }
                      
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
    
    
    
   
}
