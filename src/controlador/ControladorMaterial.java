package controlador;

import db.Conexion;
import modelo.Material;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ControladorMaterial {
    
    
    public void materialAlmacenar(Material material) throws Exception {
        
        Conexion conexion = new Conexion();
        
        try {
            
            Connection conn = conexion.getConnection();
            Statement stmt = conn.createStatement();
            
            String consulta = "INSERT INTO material VALUES ("
                    + "'" + material.getCodigo() + "', "
                    + "'" + material.getNombre() + "', "
                    + "'" + material.getFormato() + "', "
                    + "" + material.getDuracion() + ", "
                    + "'" + material.getCategoria() + "', "
                    + "'" + material.getAutor() + "', "
                    + "" + material.isEstado() + ");";
            
            System.out.println("CONSULTA A EJECUTAR: " + consulta);
            stmt.executeUpdate(consulta);    
        }
        
        catch (Exception err) {
            
            System.out.println("ERROR: " + err.getMessage());
            throw err;
        }   
    }
    
    
    public ArrayList<Material>MaterialListar(String codigo){
        
        ArrayList<Material>listaMateriales = new ArrayList<>();
        Conexion conexion = new Conexion();
        
        
        try {
            
            Connection conn = conexion.getConnection();
            Statement stmt = conn.createStatement();
            
            String consulta = "SELECT codigo, nombre, formato, "
                    + "duracion, categoria, autor, "
                    + "nuevo FROM material "
                    + "WHERE codigo LIKE '" + codigo + "%';";
            
            System.out.println("CONSULTA A EJECUTAR: " + consulta);
            
            ResultSet rs = stmt.executeQuery(consulta);
            
            while (rs.next()) {
                
                Material material = new Material();
                
                material.setCodigo(rs.getString("codigo"));
                material.setNombre(rs.getString("nombre"));
                
                if (rs.getString("formato").equalsIgnoreCase("d")) {
                    material.setFormato("Documental");
                }
                else if (rs.getString("formato").equalsIgnoreCase("p")) {
                    material.setFormato("Pelicula");
                }
                
                material.setDuracion(rs.getInt("duracion"));
                material.setCategoria(rs.getString("categoria"));
                material.setAutor(rs.getString("autor"));
                material.setEstado(rs.getBoolean("nuevo"));
                
                listaMateriales.add(material);   
            }
            return listaMateriales;
            
            
        }
        
        catch (Exception err) {

            System.out.println("ERROR: " + err.getMessage());
            return new ArrayList<>();
        }   
    }
    
    
    
    public void materialEliminar(String codigo) throws Exception {
        
        Conexion conexion = new Conexion();
        
        try {
            
            Connection conn = conexion.getConnection();
            Statement stmt = conn.createStatement();
            
            String consulta = "DELETE FROM material"
                    + " WHERE codigo = '"
                    + codigo + "';";
            
            System.out.println("CONSULTA A EJECUTAR: " + consulta);   
            stmt.executeUpdate(consulta);
        }
        
        catch (Exception err) {
            
            System.out.println("ERROR: " + err.getMessage());
            throw err;   
        } 
    }
    
    
    public void materialModificar(Material material) throws Exception {
        
        Conexion conexion = new Conexion();
        
        try {
            
            Connection conn = conexion.getConnection();
            Statement stmt = conn.createStatement();
            
            String consulta = "UPDATE material SET "
                    + "codigo = " + "'" + material.getCodigo() + "', "
                    + "nombre = " + "'" + material.getNombre() + "', "
                    + "formato = " + "'" + material.getFormato() + "', "
                    + "duracion = " + "" + material.getDuracion() + ", "
                    + "categoria = " + "'" + material.getCategoria() + "', "
                    + "autor = " + "'" + material.getAutor() + "', "
                    + "nuevo = " + "" + material.isEstado() + ""
                    + " WHERE codigo = " + "'" + material.getCodigo() + "';";
            
            System.out.println("CONSULTA A EJECUTAR: " + consulta);
            stmt.executeUpdate(consulta);   
        }
        
        catch (Exception err) {
            
            System.out.println("ERROR: " + err.getMessage());
            throw err;
        }    
    }
    
    
    public Material materialRegistro(String codigo) {
        
        Material material = new Material();
        Conexion conexion = new Conexion();
        
        try {
            
            Connection conn = conexion.getConnection();
            Statement stmt = conn.createStatement();
            
            String consulta = "SELECT codigo, nombre, formato, "
                    + "duracion, categoria, autor, "
                    + "nuevo FROM material "
                    + "WHERE codigo = '" + codigo + "';";
            
            System.out.println("CONSULTA A EJECUTAR: " + consulta);
            
            ResultSet rs = stmt.executeQuery(consulta);
            
            while (rs.next()) {
                

                
                material.setCodigo(rs.getString("codigo"));
                material.setNombre(rs.getString("nombre"));
                material.setFormato(rs.getString("formato"));
                material.setDuracion(rs.getInt("duracion"));
                material.setCategoria(rs.getString("categoria"));
                material.setAutor(rs.getString("autor"));
                material.setEstado(rs.getBoolean("nuevo"));
                   
            }
            return material;  
        }
        
        catch (Exception err) {

            System.out.println("ERROR: " + err.getMessage());
            return new Material();
        }  
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
