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
public class Mtomante {
    String fecha;
   int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     String nombre;
     int id_tipo;
     String nombre_tipo;
      
     int id_riego;
     String nombre_riego;
     
       Connection cn;
  
    DefaultTableModel modelo;
    DefaultComboBoxModel modelo2;
     DefaultComboBoxModel modelo3;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_riego() {
        return id_riego;
    }

    public void setId_riego(int id_riego) {
        this.id_riego = id_riego;
    }

    public String getNombre_riego() {
        return nombre_riego;
    }

    public void setNombre_riego(String nombre_riego) {
        this.nombre_riego = nombre_riego;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
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

    public DefaultComboBoxModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultComboBoxModel modelo3) {
        this.modelo3 = modelo3;
    }
       public Mtomante()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
     public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into mantenimiento ( nombre_mante,Fecha, id_tipo_mante, num_riego) values (?,?,?,?)";
            //Comando que maneje la 
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            
            cmd.setString(1,nombre);
            cmd.setString(2,fecha);
            cmd.setInt(3,id_tipo);
            cmd.setInt(4,id_riego);
           
            
            
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
      
       public boolean  Modificar()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE mantenimiento SET  nombre_mante=?, num_riego=?,id_tipo_mante=?"
            + " WHERE id_mantenimiento = ?";
           PreparedStatement cmd= cn.prepareStatement(sql); 
             cmd.setString(1,nombre);
           cmd.setInt(2,id_tipo);
            cmd.setInt(3,id_riego);
           cmd.setInt(4,id);
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
            String sql = "DELETE from mantenimiento  WHERE id_mantenimiento = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
           cmd.setInt(1,id);
            
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
            String sql = "SELECT * From mantenimiento" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id  = rs.getInt(1);
                    
               fecha = rs.getString(2);
               nombre = rs.getString(5);
                  id_tipo = rs.getInt(3);
                   id_riego = rs.getInt(4);
                   
                 
                modelo.addRow( new Object []{id, fecha, id_tipo,id_riego,nombre});
               
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
           String sql = "SELECT * FROM tipo_mantenimiento";
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
      public boolean cargarDatosCombo2()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT * FROM riego";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               id_riego = rs.getInt(1);
               nombre_riego = rs.getString(2);
               modelo3.addElement(new Lista(id_riego, nombre_riego));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
       public boolean cod()
{
boolean resp = false;
try{
String sql = "select MAX(id_mantenimiento) from mantenimiento";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
id= rs.getInt(1);
}
id = id + 1;

// rs.next();
// fa_cod = rs.getInt("cod");
// resp = true;
// rs.close();
// CallableStatement fa = cn.prepareCall("{call select dbo.codigo()()}");
// fa.setInt(fa_cod);
// if (!fa.execute()){
// resp = true;
// }
cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
return resp;//To change body of generated methods, choose Tools | Templates.
}
}
