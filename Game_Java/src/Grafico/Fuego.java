/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafico;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;
import Grafico.Laiker;
import Audio.Sonido;
import java.awt.Rectangle;

public class Fuego extends Actor{
  
   private Sonido sonido;
    public boolean BanderaInicio=false;
    public boolean BanderaPosicion=false;
    int MovimientoGif=0;
    int MovimientoAct=0;
int ContadorGif=0;
int movimiento=0;
boolean banderaextinguir=false;
int fuegoextinto=0;
boolean Fuegoenuso=false;
Rectangle rectafuego=new Rectangle(x+5000,y+30000,50,100);

//Rectangle rectangulo3=new Rectangle(x,y,40,50);
public Fuego(        )

    {
    super("img/fuegoPoder.png");//this.x=x;
//this.y=y;
//
      //
      //
      // y
        sprite[0][0]=sprite[0][0].getSubimage(0, 0, 50, 100);
    }


    public Fuego(String imagen,int x, int y){
      super("img/fuegoPoder.png");
x=300;
y=300;
sonido=new Sonido("fuegosonido.wav");

       

      //
      // y
        sprite[0][0]=sprite[0][0].getSubimage(0, 0, 25, 75);


    }



     //  public void setFuego(Rectangle rectangulo3) {
    //       this.rectangulo3 = rectangulo3;
   // }


      //    public Rectangle getFuego() {
       //    return rectangulo3;
    



  public Fuego(int x,int y){
      //this.x= x;
      // this.y = y;
   //   x=bolita.getX();
   //    y=bolita.getY();
    }
     
 public Rectangle getFuego() {
           return rectafuego;
    }


 public boolean getFuegoenuso() {
           return Fuegoenuso;
    }

    public void update(boolean banderainicio,int teclas,boolean ActivarSonido) throws InterruptedException{
//<Inicio de arana>
       if(ActivarSonido)
       {sonido.reproducir();}
//System.out.println(rectangulo3.getLocation()+"Fuego");
        //  Rectangle rectangulo2=new Rectangle(x,y,10,10);
         //bandera que indica que termine de extinguirse para volver acrivarse

        if(fuegoextinto<300){
        
            fuegoextinto++;
  if((teclas & _UP) != 0)
            {
      movimiento=1;
        }
         if((teclas & _DOWN)!= 0)
        {
                movimiento=2;
  }
        if((teclas & _LEFT) != 0)
            {
         movimiento=4;

        }


        if((teclas & _RIGHT) != 0)
            {
       movimiento=3;
        }

        switch(movimiento)
        {
            case 1:y--;y--;y--;y--;y--;y--;y--;y--;y--;y--;y--;y--;break;
            case 2:y++;y++;y++;y++;y++;y++;y++;y++;y++;y++;y++;y++;break;
            case 3:x++;x++;x++;x++;x++;x++;x++;x++;x++;x++;x++;x++;break;
            case 4: x--;x--;x--;x--;x--;x--; x--;x--;x--;x--;x--;x--;break;
           
        }
//x=Bolita.;
//y=Bolita.x;
        }
 else
        {
 Fuegoenuso=false;
            y=-1000;
            x=-1000;
            fuegoextinto=0;

           
 }
        rectafuego=new Rectangle(x,y+40,25,35);


    }

    public void paint(Graphics g,int a,int b,boolean activar){


        if(activar)
        {
            x=a;
            y=b;
        }

      g.drawImage(sprite[0][0], x, y , this);
   //   g.drawRect(x, y+40,25, 35);
        //g.drawImage(sprite, x, y, this);
      //  g.fillOval(x,y,50,50);
    }

   

}
