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
 * @author Todos
 */
public class MtoEmpleados {

    String dui;
    Connection cn;
   DefaultComboBoxModel modelo; 

    public DefaultTableModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultTableModel modelo2) {
        this.modelo2 = modelo2;
    }
   DefaultTableModel modelo2;
   int codigo;
   String nombre;
   
   
   String nombres;
   
    
    
    String apellido;
    String telefono;
    String estado;
    
        public MtoEmpleados()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
   
    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into Empleados (DUI_empleado, id_cargo, nombres_empleado, apellidos_empleado, Telefono, estado_civil) values (?,?,?,?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setString(1,dui);
            cmd.setInt(2,codigo);
            cmd.setString(3,nombres);
            cmd.setString(4,apellido);
             cmd.setString(5,telefono);
             cmd.setString(6,estado);
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
           String sql = "SELECT * FROM cargo_empleado";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               codigo = rs.getInt(1);
               nombre = rs.getString(2);
               modelo.addElement(new Lista(codigo, nombre));
               
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
            String sql = "UPDATE Empleados SET id_cargo = ?,nombres_empleado=?,apellidos_empleado=?,Telefono=?,estado_civil=? "
            + "WHERE DUI_empleado = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            cmd.setString(1,dui);
            cmd.setInt(2,codigo);
            cmd.setString(3,nombres);
            cmd.setString(4,apellido);
             cmd.setString(5,telefono);
             cmd.setString(6,estado);
         
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
            String sql = "DELETE from Empleados  WHERE DUI_empleado = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setString(1,dui);
            
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
            String sql = "SELECT * From Empleados" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo2.getRowCount()>0)modelo2.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               dui  = rs.getString(1);
                nombre = rs.getString(2);
                 nombres = rs.getString(3);
                 apellido = rs.getString(4);
                 telefono = rs.getString(5);
                 estado = rs.getString(6);
             
                
                modelo2.addRow( new Object []{dui, nombre, nombres,apellido,telefono,estado});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
}
