/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc_2013;

/**
 *
 * @author David 
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;



public class MtoAfiliado {
    Connection cn;
    DefaultComboBoxModel model; 
    String dui_socio;
    int id_tipo_M;
    String nombre_socio;
    String Apellido_socio;
    String telefono_socio;
    String email_socio;
    String direccion_socio;
    String profesion_socio;
    String estado_civil;
    String fecha_inicio;
    String fecha_fin;
    int num_membresia;
    String nombre;
    String Filtro;
    DefaultTableModel modelo;
    public MtoAfiliado()
    {
        Conexion con = new Conexion();
        cn= con.conectar();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFiltro() {
        return Filtro;
    }

    public void setFiltro(String Filtro) {
        this.Filtro = Filtro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DefaultComboBoxModel getModel() {
        return model;
    }

    public void setModel(DefaultComboBoxModel model) {
        this.model = model;
    }
    
    

    public String getDui_socio() {
        return dui_socio;
    }

    public void setDui_socio(String dui_socio) {
        this.dui_socio = dui_socio;
    }

    public int getId_tipo_M() {
        return id_tipo_M;
    }

    public void setId_tipo_M(int id_tipo_M) {
        this.id_tipo_M = id_tipo_M;
    }

    public String getNombre_socio() {
        return nombre_socio;
    }

    public void setNombre_socio(String nombre_socio) {
        this.nombre_socio = nombre_socio;
    }

    public String getApellido_socio() {
        return Apellido_socio;
    }

    public void setApellido_socio(String Apellido_socio) {
        this.Apellido_socio = Apellido_socio;
    }

    public String getTelefono_socio() {
        return telefono_socio;
    }

    public void setTelefono_socio(String telefono_socio) {
        this.telefono_socio = telefono_socio;
    }

    public String getEmail_socio() {
        return email_socio;
    }

    public void setEmail_socio(String email_socio) {
        this.email_socio = email_socio;
    }

    public String getDireccion_socio() {
        return direccion_socio;
    }

    public void setDireccion_socio(String direccion_socio) {
        this.direccion_socio = direccion_socio;
    }

    public String getProfesion_socio() {
        return profesion_socio;
    }

    public void setProfesion_socio(String profesion_socio) {
        this.profesion_socio = profesion_socio;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getNum_membresia() {
        return num_membresia;
    }

    public void setNum_membresia(int num_membresia) {
        this.num_membresia = num_membresia;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    

    public boolean consultarTabla()
    {
        boolean resp = false;
        try 
        {
           String  sql ="SELECT dui_socio,id_tipo_membresia, nombre_socio, apellidos_socio,telefono_socio,email_socio,direccion_socio,profesion_socio,estado_civil,num_membresia,fecha_inicio, fecha_fin FROM  afiliado  WHERE ( nombre_socio LIKE ? OR apellidos_socio LIKE ? )";
           
           PreparedStatement cmd = cn.prepareStatement(sql);
           cmd.setString(1,"%"+Filtro+"%");
            cmd.setString(2,"%"+Filtro+"%");
          ResultSet rs = cmd.executeQuery();
          while(modelo.getRowCount()>0)modelo.removeRow(0);
          while(rs.next())
          {
              resp = true;
              dui_socio= rs.getString(1);
             id_tipo_M = rs.getInt(2);
             nombre_socio = rs.getString(3);
             Apellido_socio = rs.getString(4);
             telefono_socio = rs.getString(5);
             email_socio = rs.getString(6);
             direccion_socio =rs.getString(7);
             profesion_socio= rs.getString(8);
             estado_civil =rs.getString(9);
             num_membresia = rs.getInt(10);
             fecha_inicio = rs.getString(11);
             fecha_fin = rs.getString(12);
             modelo.addRow(new Object[]{dui_socio,id_tipo_M,nombre_socio,Apellido_socio,telefono_socio,email_socio,direccion_socio,profesion_socio,estado_civil,num_membresia,fecha_inicio,fecha_fin});
              
          }
        }
 catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
}
    public boolean ConsultarAfiliados()
    {
        boolean resp = false;
        try 
        {
         String sql =("Select * from afiliado ");
         PreparedStatement cmd = cn.prepareStatement(sql);
         while(modelo.getRowCount()>0)modelo.removeRow(0);
         ResultSet rs = cmd.executeQuery();
         while(rs.next())
         {
             resp = true;
         dui_socio= rs.getString(1);
          id_tipo_M = rs.getInt(2);
             nombre_socio = rs.getString(3);
             Apellido_socio = rs.getString(4);
             telefono_socio = rs.getString(5);
             email_socio = rs.getString(6);
             direccion_socio =rs.getString(7);
             profesion_socio= rs.getString(8);
             estado_civil =rs.getString(9);
             num_membresia = rs.getInt(10);
             fecha_inicio = rs.getString(11);
             fecha_fin = rs.getString(12);
              modelo.addRow(new Object[]{dui_socio,id_tipo_M,nombre_socio,Apellido_socio,telefono_socio,email_socio,direccion_socio,profesion_socio,estado_civil,num_membresia,fecha_inicio,fecha_fin});
              
         }
         cmd.close();
         cn.close();
        }
              catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
    } 
    
    public boolean cargarDatosComboBox()
{
    boolean resp = false;
    try
    {
        String  sql =" Select * from tipo_membresia";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();
        while(rs.next())
        {
            resp = true;
            id_tipo_M = rs.getInt(1);
            nombre = rs.getString(2);
            model.addElement(new Lista (id_tipo_M, nombre));
        }
    }
    catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;

}
    public boolean AgregarAfiliados()
    {
        boolean resp = false;
        try 
        {
                
             String sql = " insert into afiliado(dui_socio,id_tipo_membresia,nombre_socio,apellidos_socio,telefono_socio,email_socio,direccion_socio,profesion_socio,estado_civil,fecha_inicio,fecha_fin)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            // cuando se maneje la consulta
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1,dui_socio);
            cmd.setInt(2, id_tipo_M);
            cmd.setString(3,nombre_socio);
            cmd.setString(4,Apellido_socio);
            cmd.setString(5,telefono_socio);
            cmd.setString(6,email_socio);
            cmd.setString(7,direccion_socio);
            cmd.setString(8,profesion_socio);
            cmd.setString(9,estado_civil);
            
           cmd.setString(10,fecha_inicio);
           cmd.setString(11,fecha_fin);
            
            if (!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            
        }
        catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;
    }  
 
    public boolean modificarAfiliados()
    {
        boolean resp = false;
        try
        {
            String sql= "UPDATE afiliados SET id_tipo_membresia = ?,nombre_socio = ?,apellido_socio= ?,telefono_socio = ?,email_socio = ?,direccion_socio = ?,profesion_socio = ?,estado_civil = ?,num_membresia = ?,fecha_inicio= ? ,fecha_fin = ?, WHERE dui_socio = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
//llenar los parametros
            cmd.setString(1,dui_socio);
            cmd.setInt(2, id_tipo_M);
            cmd.setString(3,nombre_socio);
            cmd.setString(4,Apellido_socio);
            cmd.setString(5,telefono_socio);
            cmd.setString(6,email_socio);
            cmd.setString(7,direccion_socio);
            cmd.setString(8,profesion_socio);
            cmd.setString(9,estado_civil);
            cmd.setInt(10, num_membresia);
           cmd.setString(11,fecha_inicio);
           cmd.setString(12,fecha_fin);
            //Si da error devuelve 1, caso contrario 0
             //tomen en cuenta el "!" de negación
                   if(!cmd.execute())
                    {
                       resp = true;
                     }
                    cmd.close();
                    cn.close();
        }
        catch (Exception e)
                
                {
                 System.out.println(e.toString());   
                }
        return resp;
    }
    public boolean eliminarAfiliado()
       {
           boolean resp = false;
           try
           {
               //Realizar consulta DELETE
                         String sql = "DELETE FROM cargo_empleado WHERE dui_socio = ?;"; 
                         PreparedStatement cmd = cn.prepareStatement(sql);
                         
                         cmd.setString(1, dui_socio);
                         if(!cmd.execute())
                            {
                                 resp = true;
                            }
                                       cmd.close();
                                       cn.close();
           }
           catch (Exception e)
                
                {
                 System.out.println(e.toString());   
                }
        return resp;
                
       }

    


    public boolean codFact() {
        boolean resp = false;
        try{
          String sql = "select MAX(num_membresia) from afiliado";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              num_membresia = rs.getInt(1);
          }
          num_membresia = num_membresia + 1;
        

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;//To change body of generated methods, choose Tools | Templates.
    }

    
