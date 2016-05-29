
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

/**
 *
 * @author David
 */
public class MtoFactura {
      Connection cn;

    int codigo_factura;
    int codigo_producto;
    
    double precio;
    
    
    String fecha;
   
    String DUI_empleado;
    String Nombre;
    
     DefaultComboBoxModel modelo; 
    
    double  total;
    
      public MtoFactura()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }

    public int getCodigo_factura() {
        return codigo_factura;
    }

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }
    
    

    public void setCodigo_factura(int codigo_factura) {
        this.codigo_factura = codigo_factura;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDUI_empleado() {
        return DUI_empleado;
    }

    public void setDUI_empleado(String DUI_empleado) {
        this.DUI_empleado = DUI_empleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
               Nombre = rs.getString(2);
               
               
               modelo.addElement(new Lista(DUI_empleado, Nombre));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
    
    
    
      
        public boolean insertar_Factura(){
    boolean resp = false;
        try {
            String sql = "INSERT INTO factura VALUES(?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            
            cmd.setString(1, fecha);
                    
            cmd.setDouble(2, total);
            
            cmd.setString(3, DUI_empleado);
            
            
           
            if (!cmd.execute()) {
                resp = true;
            }
            cmd.close();
            cn.close();
        } 
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    
    
    
    public boolean insertar_Detale(){
    boolean resp = false;
        try {
            String sql = "INSERT INTO Detalle_Factura(codigo_producto, id_factura, precio_producto) VALUES(?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, codigo_producto);
            cmd.setInt(2, codigo_factura);
            cmd.setDouble(3, precio);
            
            if (!cmd.execute()) {
                resp = true;
            }
            cmd.close();
            cn.close();
        } 
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    

     
    public boolean codFact() {
        boolean resp = false;
        try{
          String sql = "select MAX(id_factura) from factura";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              codigo_factura = rs.getInt(1);
          }
          codigo_factura = codigo_factura + 1;
        

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;//To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    

}
