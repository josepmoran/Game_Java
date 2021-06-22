package Entrada;
import Utils.Constantes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Key implements KeyListener, Constantes{

    private boolean left;
    private boolean right;
    private boolean ka;
    private boolean ks;
    private boolean down;
    private boolean up;
    private boolean enter;

    public Key(){
        left = right = down = up = ka = ks = enter = false;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT   :  left  = true; break;
            case KeyEvent.VK_RIGHT  :  right = true; break;
            case KeyEvent.VK_UP     :  up    = true; break;
            case KeyEvent.VK_DOWN   :  down  = true; break;
            case KeyEvent.VK_A      :  ka    = true; break;
            case KeyEvent.VK_S      :  ks    = true; break;
            case KeyEvent.VK_ENTER  :  enter = true; break;
        }

    }

    public void keyReleased(KeyEvent e) {

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT   :  left  = false; break;
            case KeyEvent.VK_RIGHT  :  right = false; break;
            case KeyEvent.VK_UP     :  up    = false; break;
            case KeyEvent.VK_DOWN   :  down  = false; break;
            case KeyEvent.VK_A      :  ka    = false; break;
            case KeyEvent.VK_S      :  ks    = false; break;
            case KeyEvent.VK_ENTER  :  enter = false; break;
        }

    }

    public int getKeyPressed(){
        int code = 0;

        if(ka)
            code+= _KEY_A;

        if(ks)
            code+= _KEY_S;

        if(left)
            code+= _LEFT;

        if(right)
            code+= _RIGHT;

        if(down)
            code+= _DOWN;

        if(up)
            code+= _UP;

        if(enter)
            code+= _ENTER;

        return code;
    }

}
