

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafico;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

/**
*
* @author fede
*/
public class Laser {
  protected Image image;
  protected int x,y;
  private final int SPEED = 5;
  private boolean visible;

  public Laser(int x, int y){
      ImageIcon ii = new ImageIcon(this.getClass().getResource("img/fuegoPoder.png"));
      image = ii.getImage();
      visible = true;
      this.x = x;
      this.y = y;
  }

  public int getX(){
      return x;
  }

  public int getY(){
      return y;
  }

  public Image getImage(){
      return image;
  }


  public Rectangle getBounds(){
      return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
  }

  public boolean isVisible(){
      return visible;
  }

  public void setVisible(boolean visible){
      this.visible = visible;
  }

  public void update(){
      y -= SPEED;
      if(y<0)
          visible=false;



}}
