package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    

    public static final String SERVER = "localhost:3306";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DB = "material_db";
    
    public Connection getConnection(){
        
        Properties propiedadesConexion = new Properties();
        
        try {
            
            propiedadesConexion.put("user", USER);
            propiedadesConexion.put("password", PASS);
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + SERVER + "/" + DB + "?serverTimezone=UTC",
                    propiedadesConexion);
            System.out.println("CONEXIÓN ESTABLECIDA CORRECTAMENTE");
            return conn;    
        }
        
        catch (Exception err) {
            System.out.println("ERROR AL CONECTAR: " + err.getMessage());
            return null;
        }    
    }
    
}
