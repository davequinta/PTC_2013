package circuito_riego;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author laboratorio 3
 */
public class Conexion {
    public Connection conectar()
    {
        Connection cn=null;
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://SERRANO\\SQLEXPRESS;databaseName=EXPO_TECNICA_DEFENSA_FINAL;integratedSecurity=true;");
        }
        catch (Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
        return cn;
    }
    
    
}
