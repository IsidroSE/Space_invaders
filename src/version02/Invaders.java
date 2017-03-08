package version02;


/*@author Isidro*/

/**     Curso Básico de desarrollo de Juegos en Java - Invaders
        (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
        http://www.planetalia.com
*/

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Invaders {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public Invaders () {
        JFrame ventana = new JFrame("Invaders");
        ventana.setBounds(0, 0, WIDTH, HEIGHT);
        ventana.setVisible(true);
        
        ventana.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    public static void main(String[] args) {
        Invaders inv = new Invaders();
    }

}
