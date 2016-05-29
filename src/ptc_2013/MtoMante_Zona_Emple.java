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
public class MtoMante_Zona_Emple {
    
     Connection cn;
   DefaultComboBoxModel modelo; 
   DefaultComboBoxModel modelo2; 
    DefaultComboBoxModel modelo3; 
   
      DefaultTableModel modelo4;
   
   String DUI_empleado;
   String Nombre_empleado;
   
   
   int Num_zona;
   String nombre_zona;
   
   int id_mantenimiento;
   String nombre_mante;
   
   String fecha;
   String horario;
   String horario_hasta;
   
   
   
   
   
      public MtoMante_Zona_Emple()
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

    public DefaultComboBoxModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultComboBoxModel modelo3) {
        this.modelo3 = modelo3;
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

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public String getNombre_mante() {
        return nombre_mante;
    }

    public void setNombre_mante(String nombre_mante) {
        this.nombre_mante = nombre_mante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public DefaultTableModel getModelo4() {
        return modelo4;
    }

    public void setModelo4(DefaultTableModel modelo4) {
        this.modelo4 = modelo4;
    }
      
    
    
    
     public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into mante_zonas_empleados (DUI_empleado, id_mantenimiento, Num_zona,  horario, horario_hasta) values (?,?,?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,DUI_empleado);
            cmd.setInt(2,id_mantenimiento);
          
            cmd.setInt(3,Num_zona);
            
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
               
               
               modelo3.addElement(new Lista(id_mantenimiento, nombre_mante));
               
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
           String sql = "SELECT dbo.zonas.nombre_zona, dbo.mantenimiento.nombre_mante, dbo.Empleados.nombres_empleado FROM     dbo.Empleados INNER JOIN\n" +
"                  dbo.mante_zonas_empleados ON dbo.Empleados.DUI_empleado = dbo.mante_zonas_empleados.DUI_empleado INNER JOIN\n" +
"                  dbo.mantenimiento ON dbo.mante_zonas_empleados.id_mantenimiento = dbo.mantenimiento.id_mantenimiento INNER JOIN\n" +
"                  dbo.zonas ON dbo.mante_zonas_empleados.Num_zona = dbo.zonas.Num_zona";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo4.getRowCount()>0)modelo4.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
              
               DUI_empleado = rs.getString(1);
                id_mantenimiento = rs.getInt(2);
                 Num_zona = rs.getInt(3);
               
               
                
                modelo4.addRow( new Object []{DUI_empleado, id_mantenimiento, Num_zona});
               
            }
                      
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
       
      
    
}
