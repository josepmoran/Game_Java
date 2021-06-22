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
public class FuegoPrestonF extends Actor{
    int InicioAranaX=0;
    int InicioAranaY=200;
    boolean BanderaInicio=true;
    int MovimientoGif=1;
    int MovimientoAct=0;
int ContadorGif=0;
boolean muerto=false;
int hp=100;
boolean gritodemuerte=false;
Rectangle Fpf=new Rectangle(-40,0,40,50);
 private Sonido sonido;

    public FuegoPrestonF(String imagen){
      super(imagen);
    //  sonido=new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/grunido.wav");
//403 358
      //114
      //119
      //100 y
        sprite[0][0] = cargaSprite(imagen);
int posx=0;
int posy=0;
      //  sprite[0][0]=sprite[0][0].getSubimage(0, 0, 45, 45);
for(int z=1;z<=3;z++)
{
    for(int za=0;za<=3;za++)
    {


      sprite[za][z]=sprite[0][0].getSubimage(posx, posy, 192, 192);

      posx=posx+192;

    }
    posx=0;
  posy=posy+192;

}


    }



    


          public Rectangle getFpf() {
           return Fpf;
    }

     public boolean getMuerto() {
           return muerto;
    }



   // public Enemigo(int x,int y){
    //    this.x= x;
    //    this.y = y;
   // }


    public void update(int posx,int posy){
//<Inicio de arana>

x=posx;
y=posy;







        //  Rectangle rectangulo2=new Rectangle(x,y,10,10);
       
if(BanderaInicio==true)
{
    InicioAranaX=200;
    y=InicioAranaY+y;
    BanderaInicio=false;
}
//</Inicio de Fuego>
 else{
InicioAranaX=0;
              if(y==0)
                  BanderaInicio=true;
              else{
    


      MovimientoGif=3;
         y--;
         y--;
            ContadorGif++;
         if( ContadorGif==20)
              MovimientoAct=1;
         if(ContadorGif==30)
             MovimientoAct=2;
if(ContadorGif==40)
  MovimientoAct=3;
            if(ContadorGif==50)
  MovimientoAct=4;
              if(ContadorGif==60){

            MovimientoGif=2;
MovimientoAct=0;
                  }
               if(ContadorGif==70){

           MovimientoAct=1;

                  }
              if(ContadorGif==80){

           MovimientoAct=2;

                  }
              if(ContadorGif==90){

           MovimientoAct=3;

                  }
  if(ContadorGif==100){

           MovimientoAct=4;

                  }
            if(ContadorGif==110){

          MovimientoGif=2;
           MovimientoAct=0;
                  }

                if(ContadorGif==120){


           MovimientoAct=1;
                  }

               if(ContadorGif==130){


           MovimientoAct=2;
                  }

               if(ContadorGif==140){


           MovimientoAct=3;
                  }

             if(ContadorGif==150){


           MovimientoAct=4;
           ContadorGif=0;
                  }


          
        }}

Fpf=new Rectangle(x+20,y,100,100);
    }

    public void paint(Graphics g){
        
        
      g.drawImage(sprite[MovimientoGif][MovimientoAct], x,y, this);
 //g.drawRect(x+20, y, 100,100);
      
    }


}
