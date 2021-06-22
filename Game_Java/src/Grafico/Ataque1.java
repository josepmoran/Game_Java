/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafico;

/**
 *
 * @author laiker
 */

import Audio.Sonido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;
import Grafico.Laiker;
import java.awt.Rectangle;


public class Ataque1 extends Actor{
 private Sonido sonido;
Rectangle rectaque1=new Rectangle(x+5000,y+3000,20,20);
boolean activar=false;
    public boolean BanderaInicio=false;
    public boolean BanderaPosicion=false;
    int MovimientoGif=0;
    int MovimientoAct=0;
int ContadorGif=0;
int movimiento=0;
boolean banderaextinguir=false;
int fuegoextinto=0;

//Rectangle rectangulo3=new Rectangle(x,y,40,50);
public Ataque1(        )

    {
    super("img/attack1.png");//this.x=x;
//this.y=y;
//
      //
      //
      // y
       // sprite[0][0]=sprite[0][0].getSubimage(0, 0, 50, 100);
 // sprite[1][0]=sprite[0][0].getSubimage(0, 0, 50, 100);
    }

public boolean getBanderaataque(){
    return activar;
}


    public Ataque1(String imagen,int x, int y){

      super(imagen);

      sonido=new Sonido("attack1.wav");
    
      int posx=0;
      int posy=0;
x=300;
y=300;//
      //
      // y
sprite[0][0] = cargaSprite(imagen);
      //  sprite[0][0]=sprite[0][0].getSubimage(0, 0, 45, 45);
for(int z=1;z<=9;z++)
{

    if(z<6){
      sprite[0][z]=sprite[0][0].getSubimage(posx, 0, 45, 45);
     posx=posx+45;
    }
 else
    {
        sprite[0][z]=sprite[0][0].getSubimage(0, 45, 45, 45);
         sprite[0][z]=sprite[0][0].getSubimage(45, 45, 45, 45);
    }

}



    }


  public Rectangle getAtaque1() {
           return rectaque1;
    }




 



    public void update(int posicionX,int posicionY,int posicionaaid,boolean activarataque) throws InterruptedException{
// 3 arriba,0 abajo,1 izquierda, 2 derecha


        if(activarataque){
sonido.reproducir();
            activar=true;
        }

        if(activar){
        switch (posicionaaid)
        {
            case 0:x=posicionX-5;
y=posicionY+20;

break;
            case 1: x=posicionX-35;y=posicionY;break;

            case 2: x=posicionX+25;y=posicionY;break;
            case 3:x=posicionX-10; y=posicionY-30;
                break;


}
movimiento=movimiento+4;

    if(movimiento<10)
            MovimientoGif=1;
        else
            if(movimiento<20)
                MovimientoGif=2;
            else
                if(movimiento<30)
                    MovimientoGif=3;
 else
                if(movimiento<40)
                    MovimientoGif=4;
 else
                if(movimiento<50)
                    MovimientoGif=5;
 else
                if(movimiento<60)
                    MovimientoGif=6;
 else
                if(movimiento<70)
                    MovimientoGif=7;
 else
                if(movimiento>80)
                    MovimientoGif=8;
                else{
                   movimiento=0;
                   activar=false;
                }
if(activar)
 rectaque1=new Rectangle(x,y,40,40);
else
    rectaque1=new Rectangle(0,0,0,0);
    }



    }

    public void paint(Graphics g){

       if(activar){
      g.drawImage(sprite[0][MovimientoGif], x, y , this);
      //g.drawRect(x, y, 40, 40);
      x=-100;
      y=-100;

   //   System.out.println(MovimientoGif);

        //g.drawImage(sprite, x, y, this);
      //  g.fillOval(x,y,50,50);
    }}}




