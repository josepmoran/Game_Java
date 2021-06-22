package Grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import Audio.Sonido;
public class Fondo extends Canvas{

    int w;
    int h;
    int x;
    int y;
   public int Moverx=0;//para mover la pantalla x
    int Movery=0;//para mover la pantalla en z
    protected BufferedImage sprite;
    Rectangle Reacnivel2=new Rectangle(x,0,798,60);
    Rectangle ReacArriba=new Rectangle(x,0,798,60);
  Rectangle ReacArriba2=new Rectangle(799,0,1,60);
     Rectangle ReacIzquierda=new Rectangle(x,61,50,550);

      Rectangle ReacEscaleraI=new Rectangle(x+2000,0,30,272);
       Rectangle ReacEscaleraI1=new Rectangle(x+2000,0,1,272);
        Rectangle ReacEscaleraI2=new Rectangle(x+2029,0,1,272);
         Rectangle ReacEscaleraI3=new Rectangle(x+2000,271,30,1);

               Rectangle ReacEscaleraD1=new Rectangle(x+2280,0,1,272);
                     Rectangle ReacEscaleraD2=new Rectangle(x+2309,0,1,272);
                           Rectangle ReacEscaleraD3=new Rectangle(x+2280,271,30,1);

                           Rectangle finalderecha=new Rectangle(x+1755,0,2,625);
                        //   Rectangle final1=new Rectangle(x+1755,0,2,625);
                            private Sonido sonido;


                    //          g.drawRect(x+2280,0,1,272);
    //  g.drawRect(x+2309,0,1,272);
    ///   g.drawRect(x+2280,271,30,1);
       Rectangle ReacEscaleraD=new Rectangle(x+2280,0,30,272);

    public Fondo(int w, int h){
        this.w = w;
        this.h = h;
    }


    public Fondo(String image){
        sprite = cargaSprite(image);
        h = sprite.getHeight();
        w = sprite.getWidth();
        sprite.getSubimage(x, y, w, h);
        sonido=new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/wolfi.wav");
    }


     public void setReacEscaleraI(Rectangle ReacEscaleraI) {
           this.ReacEscaleraI = ReacEscaleraI;
    }

          public Rectangle getReacEscaleraI() {
           return ReacEscaleraI;
    }


         public void setReacEscaleraI1(Rectangle ReacEscaleraI1) {
           this.ReacEscaleraI1 = ReacEscaleraI1;
    }

          public Rectangle getReacEscaleraI1() {
           return ReacEscaleraI1;
    }

           public void setReacEscaleraI2(Rectangle ReacEscaleraI2) {
           this.ReacEscaleraI2 = ReacEscaleraI2;
    }

          public Rectangle getReacEscaleraI2() {
           return ReacEscaleraI2;
    }

           public void setReacEscaleraI3(Rectangle ReacEscaleraI3) {
           this.ReacEscaleraI3 = ReacEscaleraI3;
    }

          public Rectangle getReacEscaleraI3() {
           return ReacEscaleraI3;
    }

           public Rectangle getReacfinalderecha() {
           return finalderecha;
    }


      public void setReacEscaleraD(Rectangle ReacEscaleraD) {
           this.ReacEscaleraD = ReacEscaleraD;
    }



          public Rectangle getReacEscaleraD() {
           return ReacEscaleraD;
    }

            public Rectangle getReacEscaleraD1() {
           return ReacEscaleraD1;
    }
             public void setReacEscaleraD1(Rectangle ReacEscaleraD1) {
           this.ReacEscaleraD1 = ReacEscaleraD1;
    }



          public Rectangle getReacEscaleraD2() {
           return ReacEscaleraD2;
    }   public void setReacEscaleraD2(Rectangle ReacEscaleraD2) {
           this.ReacEscaleraD2 = ReacEscaleraD2;
    }



          public Rectangle getReacEscaleraD3() {
           return ReacEscaleraD3;
    }   public void setReacEscaleraD3(Rectangle ReacEscaleraD3) {
           this.ReacEscaleraD3 = ReacEscaleraD3;
    }

     public Rectangle getReacnivel2()
    {
     return Reacnivel2;

    }




public  int getPosicion (){
    return Moverx;
}





   public void setFondoArriba2(Rectangle ReacArriba2) {
           this.ReacArriba2 = ReacArriba2;
    }






          public Rectangle getFondoArriba2() {
           return ReacArriba2;
    }
      public void setFondoArriba(Rectangle ReacArriba) {
           this.ReacArriba = ReacArriba;
    }


          public Rectangle getFondoArriba() {
           return ReacArriba;
    }


           public void setFondoIzquierda(Rectangle ReacIzquierda) {
           this.ReacIzquierda = ReacIzquierda;
    }


          public Rectangle getFondoIzquierda() {
           return ReacIzquierda;
    }

    public final BufferedImage cargaSprite(String imagen){
        try{
            URL url = getClass().getClassLoader().getResource(imagen);
            return ImageIO.read(url);
        }catch(Exception e){
            return null;
        }
    }
    public void update(boolean DesplazarPx)


    {
if(DesplazarPx){
    if(Moverx==200)
        sonido.reproducir();

    if(Moverx==400)
        sonido.reproducir();
    Moverx++;
    x--;
ReacArriba=new Rectangle(x,0,798,60);
ReacArriba2=new Rectangle(x+799,0,1,60);
ReacIzquierda=new Rectangle(x,61,50,550);
//ReacEscaleraI=new Rectangle(x+2000,0,30,272);
//ReacEscaleraD=new Rectangle(x+2280,0,30,272);
ReacEscaleraI1=new Rectangle(x+1425,0,1,272);
ReacEscaleraD1=new Rectangle(x+1720,0,1,272);
ReacEscaleraI2=new Rectangle(x+1454,0,1,272);
ReacEscaleraD2=new Rectangle(x+1744,0,1,272);
ReacEscaleraI3=new Rectangle(x+1425,271,30,1);
ReacEscaleraD3=new Rectangle(x+1720,271,30,1);
finalderecha=new Rectangle(x+1750,0,60,600);
 Reacnivel2=new Rectangle(x+1454,0,300,100);
        }

    //  ReacArriba.getBounds2D();
    }
    public void paint(Graphics g){
      //  g.drawImage(sprite, 20, 0, 805, 625, this); lo cambio para que la nueva pantalla se muestre por partes
        g.drawImage(sprite, -Moverx, Movery, 1755, 625, this);
     //   g.drawRect(x,0,798,60);
     //   g.drawRect(x+799,0,1,60);
     //   g.drawRect(x,61,50,550);//rectanguloi
     //   g.drawRect(x+2000,0,30,272);   para el primero escalon,izquierdo
     //    g.drawRect(x+1425,0,1,272);
    //  g.drawRect(x+1454,0,1,272);
    //   g.drawRect(x+1425,271,30,1);
        // g.drawRect(x+2280,0,30,272);//escaleras derecho
      //     g.drawRect(x+1720,0,1,272);
    //  g.drawRect(x+1744,0,1,272);
    //   g.drawRect(x+1720,271,30,1);
    //   g.drawRect(x+1750,0,60,600);
        System.out.println("Valor x del escenario"+ Moverx);
       
    }

}
