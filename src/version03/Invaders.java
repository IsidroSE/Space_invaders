package version03;


/*@author Isidro*/

/**     Curso Básico de desarrollo de Juegos en Java - Invaders
        (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
        http://www.planetalia.com
*/

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Invaders extends Canvas {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public Invaders () {
        JFrame ventana = new JFrame("Invaders");
        
        JPanel panel = (JPanel)ventana.getContentPane();
        setBounds(0, 0, WIDTH, HEIGHT);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        panel.add(this);
        
        ventana.setBounds(0, 0, WIDTH, HEIGHT);
        ventana.setVisible(true);
        
        ventana.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillOval( WIDTH/2-10, HEIGHT/2-10, 20, 20);
    }
    
    public static void main(String[] args) {
        Invaders inv = new Invaders();
    }

}
