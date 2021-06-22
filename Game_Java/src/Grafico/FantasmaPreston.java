/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafico;

/**
 *
 * @author laiker
 */
//package Grafico;
import Audio.Sonido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;
public class FantasmaPreston extends Actor{
    int InicioFX=1000;
    int InicioFY=200;
    boolean BanderaInicio=true;
    int MovimientoGif=0;
    int MovimientoAct=0;
int ContadorGif=0;
boolean muerto=false;
int hp=100;
boolean gritodemuerte=false;

 private Sonido sonido;

    public FantasmaPreston(String imagen){

      super(imagen);
       x=800;
        y=400;
     // sonido=new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/preston.wav");
//403 358
      //114
      //119
      //100 y
      sprite[0][0] = cargaSprite(imagen);
          sprite[0][1] = cargaSprite(imagen);
           sprite[0][2] = cargaSprite(imagen);
                 sprite[2][10] = cargaSprite(imagen);

             sprite[0][0]=sprite[2][10].getSubimage(0, 0, 32, 43);
             sprite[0][1]=sprite[2][10].getSubimage(32, 0, 32, 43);
             sprite[0][2]=sprite[2][10].getSubimage(64, 0, 32, 43);
             sprite[0][3]=sprite[2][10].getSubimage(96, 0, 32, 43);

              sprite[1][0]=sprite[2][10].getSubimage(0, 47, 32, 43);
             sprite[1][1]=sprite[2][10].getSubimage(32, 47, 32, 43);
             sprite[1][2]=sprite[2][10].getSubimage(64, 47, 32, 43);
             sprite[1][3]=sprite[2][10].getSubimage(96, 47, 32, 43);

             sprite[2][0]=sprite[2][10].getSubimage(0, 94, 32, 43);
             sprite[2][1]=sprite[2][10].getSubimage(32, 94, 32, 43);
             sprite[2][2]=sprite[2][10].getSubimage(64, 94, 32, 43);
             sprite[2][3]=sprite[2][10].getSubimage(96, 94, 32, 43);

              sprite[3][0]=sprite[2][10].getSubimage(0, 149, 32, 43);
             sprite[3][1]=sprite[2][10].getSubimage(32,149, 32, 43);
             sprite[3][2]=sprite[2][10].getSubimage(64, 149, 32, 43);
             sprite[3][3]=sprite[2][10].getSubimage(96, 149, 32, 43);
    }



   


        

    




    public void update(){
        x--;
           MovimientoGif=3;
         y--;
         y--;
            ContadorGif++;
         if( ContadorGif==20)
              MovimientoAct=0;
         if(ContadorGif==40)
             MovimientoAct=1;
if(ContadorGif==60)
ContadorGif=0;
//<Inicio de fantasma>
   
      





        

        
 
           
        }

    

    public void paint(Graphics g){
      g.drawImage(sprite[MovimientoGif][ MovimientoAct], x, y-300, this);
     
        //g.drawImage(sprite, x, y, this);
      //  g.fillOval(x,y,50,50);
    }


}

