package Entrada;

import Utils.Constantes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import static java.awt.event.MouseEvent.*;

public class Mouse extends Key
                   implements MouseListener,
                              MouseMotionListener,
                              MouseWheelListener,
                              Constantes{

    private int xAnt = 0;
    private int yAnt = 0;
    private boolean moved = false;
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        switch(e.getButton()){
            case MOUSE_WHEEL: System.out.println("Rueda"); break;
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
    }

}



