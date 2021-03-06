package version15;

/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;   
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Invaders extends Canvas implements Stage {

    private BufferStrategy strategy;
    private long usedTime;
    
    private SpriteCache spriteCache;
    private ArrayList actors;
    
    public Invaders() {
        spriteCache = new SpriteCache();
        
        JFrame ventana = new JFrame("Invaders");
        JPanel panel = (JPanel)ventana.getContentPane();
        setBounds(0, 0, Stage.WIDTH, Stage.HEIGHT);
        panel.setPreferredSize(new Dimension(Stage.WIDTH, Stage.HEIGHT));
        panel.setLayout(null);
        panel.add(this);
        ventana.setBounds(0,0,Stage.WIDTH,Stage.HEIGHT);
        ventana.setVisible(true);
        ventana.addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        ventana.setResizable(false);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        requestFocus();
    }
    
    public void initWorld() {
        actors = new ArrayList();
        for (int i = 0; i < 10; i++){
            Monster m = new Monster(this);
            m.setX( (int)(Math.random()*Stage.WIDTH) );
            m.setY( i*20 );
            m.setVx((int)(Math.random()*20-10));
            actors.add(m);
        }
    }
    
    public void updateWorld() {
        for (int i = 0; i < actors.size(); i++) {
            Actor m = (Actor)actors.get(i);
            m.act();
        }
    }
    
    public void paintWorld() {
        Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < actors.size(); i++) {
            Actor m = (Actor)actors.get(i);
            m.paint(g);
        }
        
        g.setColor(Color.white);
        if (usedTime > 0)
            g.drawString(String.valueOf(1000/usedTime)+" fps", 0, Stage.HEIGHT-50);
        else
            g.drawString("--- fps", 0, Stage.HEIGHT-50);
        strategy.show();
    }
    
    @Override
    public SpriteCache getSpriteCache() {
        return spriteCache;
    }
    
    public void game() {
        usedTime = 1000;
        initWorld();
        while (isVisible()) {
            long startTime = System.currentTimeMillis();
            updateWorld();
            paintWorld();
            usedTime = System.currentTimeMillis()-startTime;
            try {
                Thread.sleep(SPEED);
            }
            catch (InterruptedException e) {}
        }
    }
    
    public static void main(String[] args) {
        Invaders inv = new Invaders();
        inv.game();
    }
    
    
}
