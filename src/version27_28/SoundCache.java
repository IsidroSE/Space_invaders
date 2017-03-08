package version27_28;

/*@author Isidro*/

/**     
    Curso Básico de desarrollo de Juegos en Java - Invaders
    (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducción
    http://www.planetalia.com
*/

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundCache extends ResourceCache{
    
    @Override
    protected Object loadResource(URL url) {
        return Applet.newAudioClip(url);
    }
    
    public AudioClip getAudioClip(String name) {
        return (AudioClip)getResource(name);
    }
    
    public void playSound(final String name) {
        new Thread (
            new Runnable() {
                @Override
                public void run() {
                    getAudioClip(name).play();
                }
            }
        ).start();
    }
    
    public void loopSound(final String name) {
        new Thread (
            new Runnable() {
                @Override
                public void run() {
                    getAudioClip(name).loop();
                }
            }
        ).start();
    }

}
