package pruebatres;

import db.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import vista.VentanaPrincipal;

public class Main {



    public static void main(String[] args) {
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        vp.setTitle("Material Audiovisual");
        vp.setLocationRelativeTo(null);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image icovideo = miPantalla.getImage("src/img/icovideo.png");
        vp.setIconImage(icovideo);
        

    }
    
}
