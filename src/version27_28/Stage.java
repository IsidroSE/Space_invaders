package version27_28;

/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int SPEED = 10;
    public static final int PLAY_HEIGHT = 400;
    public SpriteCache getSpriteCache();
    public void addActor(Actor a);
    public Player getPlayer();
    public SoundCache getSoundCache();
    public void gameOver();
    
}
