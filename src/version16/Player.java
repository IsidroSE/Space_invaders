package version16;


/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

public class Player extends Actor {
    
    protected int vx;
    protected int vy;
    
    public Player(Stage stage) {
        super(stage);
        setSpriteNames( new String[] {"nave.gif"});
    }
    
    @Override
    public void act() {
        super.act();
        x += vx;
        y += vy;
        if (x < 0 || x > Stage.WIDTH)
            vx = -vx;
        if (y < 0 || y > Stage.HEIGHT)
            vy = -vy;
    }
    
    public int getVx() { return vx; }
    public void setVx(int i) {vx = i; }
    public int getVy() { return vy; }
    public void setVy(int i) {vy = i; }

}
