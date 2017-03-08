package version06;


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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.HashMap;

public class Invaders extends Canvas {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    
    public HashMap sprites;
    
    public Invaders () {
        
        sprites = new HashMap();
        
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
    
    public BufferedImage loadImage(String nombre) {
        URL url = null;
        try {
            url = getClass().getClassLoader().getResource(nombre);
            return ImageIO.read(url);
        }
        catch (Exception e) {
            System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
            System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
            System.exit(0);
            return null;
        }
    }
    
    public BufferedImage getSprite(String nombre) {
        BufferedImage img = (BufferedImage)sprites.get(nombre);
        if (img == null) { System.out.println("res/"+nombre);
          img = loadImage("res/"+nombre);
          sprites.put(nombre, img);
        }
        return img;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(getSprite("bicho.gif"), 40, 40, this);
    }
    
    public static void main(String[] args) {
        Invaders inv = new Invaders();
    }

}
