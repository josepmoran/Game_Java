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

public class Arbol extends Actor {
boolean ataquearbol=true;
    double randomValue1 = Math.random();
    Date tiempo = new Date();
    int InicioAranaX = 0;
    int dano=0;
    int InicioAranaY = 0;
    boolean BanderaInicio = true;
    int MovimientoGif = 1;
    int MovimientoAct = 1;
    int ContadorMovimento = 1;
    int Contadorpoder=0;
    boolean Llamarayuda = false;
    boolean Quitgritodemuerte = true;//para quitar el sonido por arana
    int ContadorGif = 0;
    boolean muerto = false;
    int hp = 1000;
    int Contadoraullido = 0;
    boolean gritodemuerte = false;
    Rectangle rectangulo = new Rectangle(x+10000 , y, 96, 96);
    private Sonido sonido;
    private Sonido sonido2;
    int movimientodireccion = 5;
    int hpnivel2=2000;
    int hpnivel1=200;
    boolean activarpoder;
    //inico del lobo
    

    public Arbol(String imagen, int iniciox, int inicioy) {
        super(imagen);
        x = iniciox;
        y = inicioy;

    //    sonido = new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/ataquelobo.wav");
      //  sonido2 = new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/wolfi.wav");
        int movimientodireccion = 1;

        sprite[0][0] = cargaSprite(imagen);
        int posx = 0;
        int posy = 0;
        //  sprite[0][0]=sprite[0][0].getSubimage(0, 0, 45, 45);
        for (int z = 1; z <= 4; z++) {
            for (int za = 1; za <= 3; za++) {


                sprite[z][za] = sprite[0][0].getSubimage(posx, posy, 96, 96);

                posx = posx + 96;

            }
            posx = 0;
            posy = posy + 96;

        }


    }

      public int Getdireccionataque( ){


return MovimientoGif;
}
    public boolean getbanderataque()
    {
        return ataquearbol;
    }
    public int getX( ){


return x;
}

      public int getY( ){


return y;
}
    

        public void setDano(int dano)
    {
          this.dano=dano;
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
    public boolean getActivarpoder() {
        return activarpoder;
    }

    public void update(boolean desplazarpantalla,boolean moverx) {

 randomValue1 = Math.random();
            randomValue1 = randomValue1 * 1000;
        if (ContadorMovimento == 1){
            ataquearbol=true;
            movimientodireccion = movimientodireccioncomprobar(randomValue1);

        }
        if (ContadorMovimento >=20) {
            ContadorMovimento = 0;
        //    sonido.reproducir();
        }
        ContadorMovimento++;
//ContadorMovimento++;
   //     if(hp<=0)
    //        muerto=true;

  
        

switch(estado)
{
    case vivo:
        hp=hp-dano;
        if(hp<=0)
    muerto=true;
System.out.println("el ahp es:"+ hp+ muerto);

Contadorpoder++;

if(Contadorpoder==120)
  activarpoder=true;
if(Contadorpoder==130)
{
    Contadorpoder=0;
activarpoder=false;
        }

//ContadorMovimento++;

MovimientoAct=movergif(ContadorMovimento);
if(hp>0)

        switch (movimientodireccion) {
            case 1:
                MovimientoGif = 1;
                if (y <= 500) {
                    y++;
                   

                }
                break;
            case 2:
                MovimientoGif = 2;
                if (x >= 0) {
                    x--;
                  
                }
                break;
            case 3:
                MovimientoGif = 3;
                if (x <= 600) {
                    if(!moverx)
                    x++;
                    
                }

                break;
            case 4:
                MovimientoGif = 4;
                if (y >= 0) {
                    y--;

                }

             

        }

        
       // movimientodireccion=movergif(ContadorMovimento);
System.out.println("posicion en x y y "+x+900+"Y"+y);


if(hp>0)
        rectangulo = new Rectangle(x+930 , y, 70,70);
else
     rectangulo = new Rectangle(x+930 , y+1000, 70,70);

break;
    case inactivo:
        if(desplazarpantalla)
        x--;break;
    case muerto:
        rectangulo = new Rectangle(x , y, 0,0);
        y=-200;
        System.out.println("muerto update");
        break;

    case dano:
        hp=hp-50;

 rectangulo = new Rectangle(x , y+1000, 0,0);
break;

    }

    }

    public int movergif(int contadorgi) {

        if (contadorgi == 5)// contador una variable para modificar el gif
        
            MovimientoAct = 1;
        else
        if (contadorgi == 10)
            MovimientoAct = 2;
        else
        if (contadorgi == 15)
            MovimientoAct = 3;
        
        
        System.out.println("voalor gif"+MovimientoAct);
        


        return MovimientoAct;
    }

    public int movimientodireccioncomprobar(double Value1) {//para la direccion del enemigo
        int movimientoarana = 0;
        if (Value1 <= 200) {
            movimientoarana = 1;
        } else if (Value1 <= 400) {
            movimientoarana = 2;
        } else if (Value1 <= 600) {
            movimientoarana = 3;
        } else
        if( Value1 <= 800)
        {
            movimientoarana = 4;
        }
 else
     movimientoarana=5;
        System.out.println(movimientoarana);
        return movimientoarana;

    }

    public void paint(Graphics g) {
        switch(estado)
        {

            case vivo:
                if(hp>0){
        g.drawImage(sprite[MovimientoGif][MovimientoAct], x+900, y, this);//agregar1100

//g.drawRect(x+930, y, 70, 70);
                }
break;
             case inactivo:
                 g.drawImage(sprite[4][1], x+900, y, this);
         
                break;
                  case muerto:
                      System.out.println("muerto paint");break;
            case dano:break;
        //g.drawImage(sprite, x, y, this);
        //  g.fillOval(x,y,50,50);
    }
}}
