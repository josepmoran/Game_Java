/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
import java.math.RoundingMode;
import java.util.Date;

public class Ataquearbol extends Actor {
boolean ataquearbol=true;
    double randomValue1 = Math.random();
    Date tiempo = new Date();
    int InicioAranaX = 0;
    int InicioAranaY = 0;
    boolean BanderaInicio = true;
    int MovimientoGif = 0;
    int MovimientoAct = 1;
    int ContadorMovimento = 1;
    boolean Llamarayuda = false;
    boolean Quitgritodemuerte = true;//para quitar el sonido por arana
    int ContadorGif = 0;
    boolean muerto = false;
    int hp = 500;
    int Contadoraullido = 0;
    boolean gritodemuerte = false;
    Rectangle rectangulo = new Rectangle(x , y, 96, 96);
    private Sonido sonido;
    private Sonido sonido2;
    int movimientodireccion = 3;
    int hpnivel2=2000;
    int hpnivel1=200;
    int direccionfinalpoder;
    //inico del lobo
    boolean iniciolobo=true;

    public Ataquearbol(String imagen, int iniciox, int inicioy) {
        super(imagen);
        x = iniciox;
        y = inicioy;

    //    sonido = new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/ataquelobo.wav");
      //  sonido2 = new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/wolfi.wav");
        int movimientodireccion = 1;

        sprite[0][0] = cargaSprite(imagen);
        int posx = 0;
        int posy = 0;
          sprite[0][1]=sprite[0][0].getSubimage(30, 30, 30, 30);
           sprite[0][2]=sprite[0][0].getSubimage(130, 30, 30, 30);
      


    }

    public void setEnemigo(Rectangle rectangulo) {
        this.rectangulo = rectangulo;
    }

    public Rectangle getEnemigo() {
        return rectangulo;
    }

    public boolean getMuerto() {
        return muerto;
    }

    // public Enemigo(int x,int y){
    //    this.x= x;
    //    this.y = y;
    // }
    public boolean getLlamarayuda() {
        return Llamarayuda;
    }

    public void update(int direccion,int iniciox, int inicioy, boolean activarpoder) {
        if(activarpoder){
x=iniciox;
y=inicioy;
direccionfinalpoder=direccion;
        }
        switch(estado)
        {
            case vivo:
 if(ContadorMovimento==60)
    ContadorMovimento=0;
ContadorMovimento++;
movergif(ContadorMovimento);
          

    //   movimientodireccion=3;
        if(iniciolobo){


        if(iniciolobo)
            iniciolobo=false;
        }











       switch(direccionfinalpoder){
            case 1:

                x++;x++;x++;x++;x++;
                break;
            case 2:
             //   MovimientoGif = 2;

                    y++;y++;y++;y++;y++;
                break;
            case 3:
                //MovimientoGif = 3;

                    x--;x--;x--;x--;x--;
                break;
            case 4:

                    y--;y--;y--;y--;y--;
                break;





        }




        rectangulo = new Rectangle(x+20, y+14, 1, 1);
        break;

            case inactivo:
             rectangulo = new Rectangle(x+909, y+909, 0, 0);

    }}

    public int movergif(int contadorgi) {

        if (contadorgi <= 20)// contador una variable para modificar el gif
        {
            MovimientoAct = 1;
        }
        if (contadorgi == 40) {
            MovimientoAct = 2;
        }
        return MovimientoAct;
    

  
    }

    public void paint(Graphics g) {
        switch(estado)

        {case vivo:
       g.drawImage(sprite[0][MovimientoAct], x+909, y, this);
      // g.drawRect(x+920, y+14, 1, 1);
//g.drawRect(x+909, y+4, 1, 1);
       break;

            case inactivo:
            case muerto:
                break;

//g.drawRect(x+130, y+30, 30, 30);
//g.drawRect(x+210, y+30, 30, 30);
        //g.drawImage(sprite, x, y, this);
        //  g.fillOval(x,y,50,50);
    }
}
}
