package version24;

/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

public class Monster extends Actor {
    
    protected int vx;
    protected static final double FIRING_FREQUENCY = 0.01;
    
    public Monster(Stage stage) {
        super(stage);
        setSpriteNames( new String[] {"bicho0.gif","bicho1.gif"});
        setFrameSpeed(35);
    }
    
    @Override
    public void act() {
        super.act();
        x += vx;
        if (x < 0 || x > Stage.WIDTH)
            vx = -vx;
        
        if (Math.random()<FIRING_FREQUENCY)
            fire();
    }
    
    public int getVx() { return vx; }
    public void setVx(int i) {vx = i; }
    
    @Override
    public void collision(Actor a) {
        if (a instanceof Bullet || a instanceof Bomb) {
            remove();
            stage.getPlayer().addScore(20);
        }
    }
    
    public void fire() {
        Laser m = new Laser(stage);
        m.setX(x + getWidth() / 2);
        m.setY(y + getHeight());
        stage.addActor(m);
    }

}
