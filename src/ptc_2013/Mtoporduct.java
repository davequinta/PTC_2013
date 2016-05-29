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
 * @author Molina
 */
public class Mtoporduct {
     public Mtoporduct()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
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

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
     Connection cn;
     
     int codigo;
     
     int exishuy;

    public int getExishuy() {
        return exishuy;
    }

    public void setExishuy(int exishuy) {
        this.exishuy = exishuy;
    }
     
     
     

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     String fecha;
     String nombre_producto;
     
     int id_tipo;
     String nombre_tipo;
     
     int existencia;
     String detalle;
     double precio;
     
     
    String Filtro;
    
    DefaultTableModel modelo;
    
     DefaultComboBoxModel modelo2;
     
          DefaultComboBoxModel modelo3;

    public DefaultComboBoxModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultComboBoxModel modelo3) {
        this.modelo3 = modelo3;
    }
          
          
          
          
     
      public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into productos (codigo_producto,precio_producto,nombre_producto,detalle_producto,existencia_producto,id_tipo_producto,fecha ) values (?,?,?,?,?,?,?)";
            //Comando que maneje la co
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            cmd.setInt(1,codigo);
            cmd.setDouble(2,precio);
            cmd.setString(3,nombre_producto);
            cmd.setString(4,detalle);
            cmd.setInt(5,existencia);
            cmd.setInt(6,id_tipo);
          cmd.setString(7,fecha);
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
           String sql = "SELECT * FROM tipo_producto";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               id_tipo = rs.getInt(1);
               nombre_tipo = rs.getString(2);
               modelo2.addElement(new Lista(id_tipo, nombre_tipo));
               
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
            String sql = "UPDATE productos SET precio_producto = ?,nombre_producto=?,detalle_producto=?,existencia_producto=?,id_tipo_producto=?"
            + " WHERE codigo_producto = ?";
           PreparedStatement cmd= cn.prepareStatement(sql); 
            cmd.setInt(6,codigo);
            cmd.setDouble(1,precio);
            cmd.setString(2,nombre_producto);
            cmd.setString(3,detalle);
            cmd.setInt(4,existencia);
             cmd.setInt(5,id_tipo);
           
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
            String sql = "DELETE from productos  WHERE codigo_producto = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setInt(1,codigo);
            
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
            String sql = "SELECT * From productos" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               codigo  = rs.getInt(1);
                
                 precio = rs.getDouble(2);
                 nombre_producto = rs.getString(3);
             detalle = rs.getString(4);
                   existencia = rs.getInt(5);
                   id_tipo = rs.getInt(6);
                 
                modelo.addRow( new Object []{codigo, id_tipo, precio,nombre_producto,detalle,existencia});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
       
        public boolean  consultarFiltro()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT nombre_producto,  FROM productos  WHERE  (nombre_producto LIKE ?  )";
            
            PreparedStatement cmd= cn.prepareStatement(sql); 
            
            
            cmd.setString(1,"%"+Filtro+"%");
           
     
           
           
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               
               
                nombre_producto = rs.getString(1);
                
                
             
                
                modelo.addRow( new Object []{ nombre_producto});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
        
        
     
          public boolean Stock()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT existencia_producto From productos WHERE codigo_producto = ?;";
            PreparedStatement cmd= cn.prepareStatement(sql);
            
            cmd.setInt(1,codigo);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = true;
                existencia = rs.getInt(1);
                
                
                
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
    
    
    
           public boolean actExi() {
        boolean resp = false;
        try{
          String sql = "UPDATE productos SET existencia_producto = ? + ? "
            + "WHERE codigo_producto = ? ;";
          CallableStatement cmd = cn.prepareCall(sql);
          
          
          
          cmd.setInt(1, existencia ); 
          
          cmd.setInt(2, exishuy); 
             
             
         cmd.setInt(3, codigo);
         
          
             if(!cmd.execute())
            {
                resp = true;
            }
         

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;
    }
      
           
           
    
    public boolean cargarPro()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT codigo_producto, nombre_producto FROM productos ";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               codigo = rs.getInt(1);
               nombre_producto = rs.getString(2);
               
               
               modelo3.addElement(new Lista(codigo, nombre_producto));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
     
}
