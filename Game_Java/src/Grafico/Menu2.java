
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
public class Menu2 extends Canvas{

    int w;
    int h;
    int x;
    int y;
   public int Moverx=0;//para mover la pantalla x
    int Movery=0;//para mover la pantalla en z
    protected BufferedImage sprite;



                    //          g.drawRect(x+2280,0,1,272);
    //  g.drawRect(x+2309,0,1,272);
    ///   g.drawRect(x+2280,271,30,1);


    public Menu2(int w, int h){
        this.w = w;
        this.h = h;
    }

    public final BufferedImage cargaSprite(String imagen){
        try{
            URL url = getClass().getClassLoader().getResource(imagen);
            return ImageIO.read(url);
        }catch(Exception e){
            return null;
        }
    }
    public Menu2(String image){
        sprite = cargaSprite(image);
        h = sprite.getHeight();
        w = sprite.getWidth();

    }

    public void  update()
    {

    }


    //  ReacArriba.getBounds2D();

    public void paint(Graphics g){
      //  g.drawImage(sprite, 20, 0, 805, 625, this); lo cambio para que la nueva pantalla se muestre por partes
        g.drawImage(sprite, x, y, 900, 700, this);


        System.out.println("Valor x del escenario"+ Moverx);

    }

}


