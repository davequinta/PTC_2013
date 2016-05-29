/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circuito_riego;

/**
 *
 * @author Carlos_Cornejo
 */

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
public class MtoC_Riego {
    Connection cn;
    int num_riego;
   int num_zona;
    String Fecha;
    int id_tipo_mes;
    int duracion;
    int matutino;
    int vespertino;
    String nombre;
    DefaultTableModel model;
     DefaultComboBoxModel modelo;
    public MtoC_Riego()
    {
        Conexion con = new Conexion();
        cn= con.conectar();
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public int getMatutino() {
        return matutino;
    }

    public void setMatutino(int matutino) {
        this.matutino = matutino;
    }

    public int getVespertino() {
        return vespertino;
    }

    public void setVespertino(int vespertino) {
        this.vespertino = vespertino;
    }

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }

    public int getNum_riego() {
        return num_riego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNum_riego(int num_riego) {
        this.num_riego = num_riego;
    }

    public int getNum_zona() {
        return num_zona;
    }

    public void setNum_zona(int num_zona) {
        this.num_zona = num_zona;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getId_tipo_mes() {
        return id_tipo_mes;
    }

    public void setId_tipo_mes(int id_tipo_mes) {
        this.id_tipo_mes = id_tipo_mes;
    }



   
    
    public boolean AgregarRiego()
    {
        boolean resp = false;
        try 
        {
            String sql = " insert into riego (duracion,num_zona,fecha,id_tipo_mes, matutino, vespertino)values (?,?,?,?,?,?)";
            // cuando se maneje la consulta
            PreparedStatement cmd = cn.prepareStatement(sql);
          
          
            
            cmd.setInt(1,duracion);
            cmd.setInt(2, num_zona);
            cmd.setString(3,Fecha);
            cmd.setInt(4,id_tipo_mes);
            cmd.setInt(5,matutino);
            cmd.setInt(6,vespertino);
           
            
            
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
    
    public boolean cargarDatosComboBox()
{
    boolean resp = false;
    try
    {
        String  sql =" Select * from tipo_mes";
        PreparedStatement cmd = cn.prepareStatement(sql);
        ResultSet rs = cmd.executeQuery();
        while(rs.next())
        {
            resp = true;
            id_tipo_mes = rs.getInt(1);
            nombre = rs.getString(2);
            modelo.addElement(new Lista (id_tipo_mes, nombre));
        }
    }
     catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return resp;

}
    
    public boolean codriego() {
       boolean resp = false;
        try{
        String sql = "select MAX(num_riego) from riego";
CallableStatement cmd = cn.prepareCall(sql);
ResultSet rs = cmd.executeQuery();
if(rs.next())
{
resp = true;
num_riego = rs.getInt(1);
}
num_riego = num_riego + 1;

cmd.close();
}catch(Exception e){
System.out.println("Error en : " +e.getMessage());
}
        return false;
    }
    public boolean Consultar()
    {
        boolean resp = false;
        try 
        {
         String sql =("SELECT * FROM  riego");
         PreparedStatement cmd = cn.prepareStatement(sql);
         ResultSet rs = cmd.executeQuery();
         while(model.getRowCount()>0)model.removeRow(0);
         while(rs.next())
         {
            resp = true;
            num_riego= rs.getInt(1);
            duracion= rs.getInt(2);
            num_zona = rs.getInt(3);
            Fecha= rs.getString(4);
            id_tipo_mes = rs.getInt(5);
            matutino = rs.getInt(6);
            vespertino = rs.getInt(7);
            model.addRow(new Object[]{num_riego,duracion,num_zona,Fecha,id_tipo_mes,matutino,vespertino});
            System.out.println(duracion); 
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
    
    public int[][] ConsultarDuracion( String x)
    {
        int[][] matriz = new int [32][3];
        try 
        {
         String sql =("SELECT * FROM  riego " + x);
         PreparedStatement cmd = cn.prepareStatement(sql);
         
         ResultSet rs = cmd.executeQuery();
         int i = 0;
         while(rs.next())
         {
            matriz [i] [0] = rs.getInt(1);
            matriz [i] [1] = rs.getInt(2);
            matriz [i] [2] = rs.getInt(5);
            i++;
             System.out.println("algo"); 
         }
         cmd.close();
         cn.close();
        }
              catch (Exception ex)
                {
                    System.out.println("Error: "+ ex.getMessage());
                }
        return matriz;
    } 
}
