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
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
public class MtoPlantas {
    Connection cn;
    int correlativo;
    
    int id_genero;
    String nombre_genero;
    
    int id_tipo;
    String nombre_tipo;
    
     int id_uso;
    String nombre_uso;
    
      int id_clase;
    String nombre_clase;
    
      int id_region;
    String nombre_region;
    
      int id_especie;
    String nombre_especie;
    
      int id_familia;
    String nombre_familia;
    
    
    String nombre_planta;
    int stock;
    
    
    
    int exis;
    
    
    DefaultComboBoxModel modelo;
    DefaultComboBoxModel modelo3;
    DefaultComboBoxModel modelo4;
    DefaultComboBoxModel modelo5;
    DefaultComboBoxModel modelo6;
    DefaultComboBoxModel modelo7;
    DefaultComboBoxModel modelo8;
    
    
    DefaultComboBoxModel modelo9;
    
    
    
    
    
    DefaultTableModel modelo2;

    public int getExis() {
        return exis;
    }

    public void setExis(int exis) {
        this.exis = exis;
    }

    public DefaultComboBoxModel getModelo9() {
        return modelo9;
    }

    public void setModelo9(DefaultComboBoxModel modelo9) {
        this.modelo9 = modelo9;
    }

    
    
    
    
    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
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

    public int getId_uso() {
        return id_uso;
    }

    public void setId_uso(int id_uso) {
        this.id_uso = id_uso;
    }

    public String getNombre_uso() {
        return nombre_uso;
    }

    public void setNombre_uso(String nombre_uso) {
        this.nombre_uso = nombre_uso;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getNombre_clase() {
        return nombre_clase;
    }

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public String getNombre_especie() {
        return nombre_especie;
    }

    public void setNombre_especie(String nombre_especie) {
        this.nombre_especie = nombre_especie;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }

    public DefaultComboBoxModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultComboBoxModel modelo) {
        this.modelo = modelo;
    }

    public DefaultTableModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultTableModel modelo2) {
        this.modelo2 = modelo2;
    }

    public DefaultComboBoxModel getModelo3() {
        return modelo3;
    }

    public void setModelo3(DefaultComboBoxModel modelo3) {
        this.modelo3 = modelo3;
    }

    public DefaultComboBoxModel getModelo4() {
        return modelo4;
    }

    public void setModelo4(DefaultComboBoxModel modelo4) {
        this.modelo4 = modelo4;
    }

    public DefaultComboBoxModel getModelo5() {
        return modelo5;
    }

    public void setModelo5(DefaultComboBoxModel modelo5) {
        this.modelo5 = modelo5;
    }

    public DefaultComboBoxModel getModelo6() {
        return modelo6;
    }

    public void setModelo6(DefaultComboBoxModel modelo6) {
        this.modelo6 = modelo6;
    }

    public DefaultComboBoxModel getModelo7() {
        return modelo7;
    }

    public void setModelo7(DefaultComboBoxModel modelo7) {
        this.modelo7 = modelo7;
    }

    public DefaultComboBoxModel getModelo8() {
        return modelo8;
    }

    public void setModelo8(DefaultComboBoxModel modelo8) {
        this.modelo8 = modelo8;
    }

    
    
    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
    
    
    
    
    

        public boolean cargarGenero()
      {
          boolean resp =false;
          try
          {
              String sql = "Select * from genero_plantas";
              PreparedStatement cmd = cn.prepareStatement(sql);
              ResultSet rs = cmd.executeQuery();
              while(rs.next())
              {
                  id_genero =rs.getInt(1);
                  nombre_genero = rs.getString(2);
                  modelo3.addElement(new MtoLista(id_genero, nombre_genero));
              }
              cmd.close();
              cn.close();


          }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }

    public boolean cargarTipo()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from tipo_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_tipo =rs.getInt(1);
              nombre_tipo = rs.getString(2);
              modelo.addElement(new MtoLista(id_tipo, nombre_tipo));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    
    public boolean cargarUso()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from uso_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_uso =rs.getInt(1);
              nombre_uso = rs.getString(2);
              modelo4.addElement(new MtoLista(id_uso, nombre_uso));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    
    public boolean cargarClase()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from clase_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_clase =rs.getInt(1);
              nombre_clase = rs.getString(2);
              modelo5.addElement(new MtoLista(id_clase, nombre_clase));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    
    public boolean cargarRegion()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from region_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_region =rs.getInt(1);
              nombre_region = rs.getString(2);
              modelo6.addElement(new MtoLista(id_region, nombre_region));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    public boolean cargarEspecie()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from especie_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_especie =rs.getInt(1);
              nombre_especie = rs.getString(2);
              modelo7.addElement(new MtoLista(id_especie, nombre_especie));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    public boolean cargarFamilia()
  {
      boolean resp =false;
      try
      {
          String sql = "Select * from familia_plantas";
          PreparedStatement cmd = cn.prepareStatement(sql);
          ResultSet rs = cmd.executeQuery();
          while(rs.next())
          {
              id_familia =rs.getInt(1);
              nombre_familia = rs.getString(2);
              modelo8.addElement(new MtoLista(id_familia, nombre_familia));
          }
          cmd.close();
          cn.close();
          
          
      }
      catch(Exception ex)
      {
          System.out.println("Error: " + ex.getMessage());
      }
      return resp;
  }
    
    public boolean guardarProducto()
    {
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO plantas(nombre_planta, id_tipo, id_uso, id_clase,id_region,id_especie, id_genero, id_familia, cantidad ) VALUES(?, ?, ?, ? ,? ,?, ?, ?,? )";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, nombre_planta);
            cmd.setInt(2, id_tipo);
            cmd.setInt(3, id_uso);
            cmd.setInt(4, id_clase);
            cmd.setInt(5, id_region);
            cmd.setInt(6, id_especie);
            cmd.setInt(7, id_genero);
            cmd.setInt(8, id_familia);
            cmd.setInt(9,stock);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
   

     public MtoPlantas()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
     
        public boolean codFact() {
        boolean resp = false;
        try{
          String sql = "select MAX(correlativo_plantas) from plantas";
          CallableStatement cmd = cn.prepareCall(sql);
          ResultSet rs = cmd.executeQuery();
          if(rs.next())
          {
              resp = true;
              correlativo = rs.getInt(1);
          }
          correlativo = correlativo + 1;

            cmd.close();
        }catch(Exception e){
            System.out.println("Error en : " +e.getMessage());
        }
        return resp;
    }
        
          public boolean Stock()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT cantidad From plantas WHERE correlativo_plantas = ?;";
            PreparedStatement cmd= cn.prepareStatement(sql);
            
            cmd.setInt(1,correlativo);
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = true;
                stock = rs.getInt(1);
                
                
                
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
          
            public boolean Existencia()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT cantidad From plantas WHERE correlativo_plantas = ?;";
            PreparedStatement cmd= cn.prepareStatement(sql);
            
            cmd.setInt(1,correlativo);
            
            
            ResultSet rs = cmd.executeQuery();
            if (rs.next())
            {
                resp = true;
                stock = rs.getInt(1);
                
                
                
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
          String sql = "UPDATE plantas SET cantidad = ? + ? "
            + "WHERE correlativo_plantas = ? ;";
          CallableStatement cmd = cn.prepareCall(sql);
          
          
          
          cmd.setInt(1, stock ); 
          
          cmd.setInt(2, exis); 
             
             
         cmd.setInt(3, correlativo);
         
          
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
        
        
        
        
    
        
        
        public boolean  consultarTabla()
    {
        boolean resp = false;
        try 
        {
            String sql = "SELECT correlativo_plantas, nombre_planta, nombre_genero, nombre_tipo, nombre_uso, nombre_clase, nombre_region, nombre_especie, nombre_familia, cantidad FROM plantas p, genero_plantas g, tipo_plantas t, uso_plantas u, clase_plantas c, region_plantas r, especie_plantas e, familia_plantas f WHERE (p.id_genero = g.id_genero) AND (p.id_tipo = t.id_tipo)  AND (p.id_uso = u.id_uso) AND (p.id_clase = c.id_clase) AND (p.id_region = r.id_region) AND (p.id_especie = e.id_especie)  AND (p.id_familia = f.id_familia)";   
            PreparedStatement cmd= cn.prepareStatement(sql); 
            ResultSet rs = cmd.executeQuery();
            
            while(modelo2.getRowCount()>0)modelo2.removeRow(0);
                           
            while(rs.next())
            {
               resp = true;
                 correlativo = rs.getInt(1);
                 nombre_planta = rs.getString(2);
                 nombre_tipo = rs.getString(3);
                 nombre_uso = rs.getString(4);
                 nombre_clase = rs.getString(5);
                 nombre_region = rs.getString(6);
                 nombre_especie = rs.getString(7);
                 nombre_genero = rs.getString(8);
                 nombre_familia = rs.getString(9);
                 stock = rs.getInt(10);
             
                
                modelo2.addRow( new Object []{correlativo,nombre_planta, nombre_tipo, nombre_uso, nombre_clase, nombre_region, nombre_especie, nombre_genero, nombre_familia, stock});
               
            }
                    
            
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return resp;
        
    }
        
        
    public boolean cargarDatosPlanta()
    {
       boolean resp = false;
       try
       {
           String sql = "SELECT correlativo_plantas, nombre_planta FROM plantas";
           PreparedStatement cmd= cn.prepareStatement(sql); 
           ResultSet rs = cmd.executeQuery();
           
           while(rs.next())
           {
               resp = true;
               correlativo = rs.getInt(1);
               nombre_planta = rs.getString(2);
               
               
               modelo.addElement(new Lista(correlativo, nombre_planta));
               
           }
           
       }
       catch (Exception ex)
       {
           System.out.println("Error: "+ex.getMessage());
       }
        return resp;
        
    }
        
        
     
    
    
}
