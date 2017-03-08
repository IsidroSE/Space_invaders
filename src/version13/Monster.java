package version13;

/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

public class Monster extends Actor {
    
    protected int vx;
    
    public Monster(Stage stage) {
        super(stage);
        setSpriteName("bicho.gif");
    }
    
    @Override
    public void act() {
        x += vx;
        if (x < 0 || x > Stage.WIDTH)
            vx = -vx;
    }
    
    public int getVx() { return vx; }
    public void setVx(int i) {vx = i; }

}
