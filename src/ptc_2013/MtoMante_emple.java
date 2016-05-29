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
public class MtoMante_emple {
    Connection cn;
   DefaultComboBoxModel modelo; 
   DefaultComboBoxModel modelo2; 
 
   
   
   DefaultTableModel modelo3;
   
   
   
   
   String DUI_empleado;
   String Nombre_empleado;
   
   int id_mantenimiento;
   String nombre_mante;
   
   
   String fecha;
   
   
   
      public MtoMante_emple()
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
   
    public boolean  guardar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into mante_emple (DUI_empleado, id_mantenimiento, fecha) values (?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,DUI_empleado);
            cmd.setInt(2,id_mantenimiento);
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
               
               
               modelo2.addElement(new Lista(id_mantenimiento, nombre_mante));
               
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
           String sql = "SELECT        dbo.Empleados.nombres_empleado, dbo.mantenimiento.nombre_mante FROM            dbo.Empleados INNER JOIN dbo.mante_emple ON dbo.Empleados.DUI_empleado = dbo.mante_emple.DUI_empleado INNER JOIN dbo.mantenimiento ON dbo.mante_emple.id_mantenimiento = dbo.mantenimiento.id_mantenimiento";
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo3.getRowCount()>0)modelo3.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
              
             DUI_empleado = rs.getString(1);
                nombre_mante = rs.getString(2);
                
               
                
                modelo3.addRow( new Object []{DUI_empleado,nombre_mante});
               
            }
                      
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
   
}
