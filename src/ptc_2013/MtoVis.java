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
 * @author Todos
 */
public class MtoVis {

    
     public MtoVis()
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     Connection cn;
    int codigo;
    String nombre;
    
     DefaultTableModel modelo;
     DefaultComboBoxModel modelo2; 
     
     int id;
     double monto;
     String fecha;
    int visita;
     
    int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }
     
    
     
     
     
     
     
       public boolean  guadar()
    {
        boolean resp = false;
        try 
        {
            String sql = "insert into visitantes_particulares ( monto, id_tipo_visitante,cantidad, visita, ingreso) values (?,?,?,?,?)";
            //Comando que maneje la 
            PreparedStatement cmd= cn.prepareStatement(sql);
            //Sustitute los "?"
            
            cmd.setDouble(1,monto);
            cmd.setInt(2,codigo);
            cmd.setInt(3,cantidad);
            cmd.setInt(4,visita);
            cmd.setString(5,fecha);
            
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
           String sql = "SELECT * FROM tipo_visitante";
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
    
     
      public boolean  Modificar()
    {
        boolean resp = false;
        try 
        {
            String sql = "UPDATE visitantes SET monto = ?,id_tipo_visitante=?,ingreso=? "
            + "WHERE num_visitante = ?;";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           
            
            cmd.setDouble(1,monto);
            cmd.setInt(2,codigo);
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
       public boolean  Eliminar()
  {
      boolean resp = false;
        try 
        {
            String sql = "DELETE from visitantes  WHERE num_visitante = ?;";
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
            String sql = "SELECT * From visitantes_particulares" ;
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo.getRowCount()>0)modelo.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
               id  = rs.getInt(1);
                monto = rs.getDouble(2);
                nombre = rs.getString(3);
                 fecha = rs.getString(6);
                  cantidad = rs.getInt(4);
             visita = rs.getInt(5);
             
                
                modelo.addRow( new Object []{id, monto,nombre, fecha,cantidad,visita});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
    }
        
public boolean codvis()
{
boolean resp = false;
try{
String sql = "select MAX(num_visita) from visitantes_particulares";
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
