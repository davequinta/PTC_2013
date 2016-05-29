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
public class Mtoafili {

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
     public Mtoafili()
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

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
    int codigo;
    String nombre2;
    
    DefaultTableModel modelo;
    DefaultComboBoxModel modelo2;
    
    String dui;
    String nombre;
    String tel;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    String apellido;
    String email;
    String dire;
    String pro;

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }
    String ing;
    String estado;
    int num;
    String inicio;
    String fin;
 
     Connection cn;
     
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
               nombre2 = rs.getString(2);
               modelo2.addElement(new Lista(codigo, nombre2));
               
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
String sql = "select MAX(num_membresia) from afiliado";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
num= rs.getInt(1);
}
num = num + 1;

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
             
              public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into afiliado ( dui_socio,id_tipo_membresia, nombre_socio, apellidos_socio,telefono_socio,email_socio,direccion_socio,profesion_socio,estado_civil,fecha_inicio,fecha_fin,fecha_ingreso) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            //Comando que maneje la 
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            
            cmd.setString(1,dui);
            cmd.setInt(2,codigo);
            cmd.setString(3,nombre);
            cmd.setString(4,apellido);
            cmd.setString(5,tel);
            cmd.setString(6,email);
            cmd.setString(7,dire);
            cmd.setString(8,pro);
            cmd.setString(9,estado);
            cmd.setString(10,inicio);
            cmd.setString(11,fin);
            cmd.setString(12,ing);
            
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
            String sql = "UPDATE afiliado SET  id_tipo_membresia=?, nombre_socio=?,apellidos_socio=?,telefono_socio=?, email_socio=?,direccion_socio=?,profesion_socio=?, estado_civil=?"
            + " WHERE dui_socio = ?";
           PreparedStatement cmd= cn.prepareStatement(sql); 
              cmd.setString(11,dui);
            cmd.setInt(1,codigo);
            cmd.setString(2,nombre);
            cmd.setString(3,apellido);
            cmd.setString(4,tel);
            cmd.setString(5,email);
            cmd.setString(6,dire);
            cmd.setString(7,pro);
            cmd.setString(8,estado);
           
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
            String sql = "DELETE from afiliado  WHERE dui_socio = ?;";
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
            String sql = "SELECT * From afiliado" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               dui  = rs.getString(1);
                    codigo = rs.getInt(2);
               nombre = rs.getString(3);
                  apellido = rs.getString(4);
                   tel = rs.getString(5);
                    email = rs.getString(6);
                  dire = rs.getString(7);
                   pro = rs.getString(8);
                    estado = rs.getString(9);
                     num = rs.getInt(10);
                  inicio = rs.getString(11);
                   fin = rs.getString(12);
                    ing = rs.getString(12);
                 
                modelo.addRow( new Object []{dui, codigo, nombre,apellido,tel,email,dire,pro,estado,num,inicio,fin,ing});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
     
}
