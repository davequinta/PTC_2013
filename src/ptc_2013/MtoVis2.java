/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class MtoVis2 {
    
    Connection cn;
    
     int codigo;
    String nombre;
    
     DefaultTableModel modelo;
     DefaultComboBoxModel modelo2; 
     
     String fecha;
     Double cantidad;
     
    
     public MtoVis2()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
       public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into visitantes_miembros (  id_tipo_visitante_membresia,cantidad_membre, fecha_ingreso) values (?,?,?,?)";
            //Comando que maneje la 
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
       
            cmd.setInt(1,codigo);
            cmd.setDouble(2,cantidad);
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
     
     public boolean cargarDatosCombo()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT * FROM tipo_membresia";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               codigo = rs.getInt(1);
               nombre = rs.getString(2);
               modelo2.addElement(new Lista(codigo, nombre));
               
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
            String sql = "SELECT * From visitantes_particulares" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
             
                nombre = rs.getString(1);
                cantidad = rs.getDouble(2);
                 fecha = rs.getString(3);
                 
             
             
                
                modelo.addRow( new Object []{nombre, cantidad, fecha});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
    }
    
}
