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

public class Lobo extends Actor {

    double randomValue1 = Math.random();
    Date tiempo = new Date();
    int InicioAranaX = 0;
    int InicioAranaY = 0;
    boolean BanderaInicio = true;
    int MovimientoGif = 1;
    int MovimientoAct = 1;
    int ContadorMovimento = 1;
    boolean Llamarayuda = false;
    boolean Quitgritodemuerte = true;//para quitar el sonido por arana
    int ContadorGif = 0;
    boolean muerto = false;
    int hp = 500;
    int Contadoraullido = 0;
    boolean gritodemuerte = false;
    Rectangle rectangulo = new Rectangle(x , y, 50, 50);
    private Sonido sonido;
    private Sonido sonido2;
    int movimientodireccion = 3;
    int hpnivel2=2000;
    int hpnivel1=200;
    //inico del lobo
    boolean iniciolobo=true;

    public Lobo(String imagen, int iniciox, int inicioy) {
        super(imagen);
        x = iniciox;
        y = inicioy;

        sonido = new Sonido("ataquelobo.wav");
        sonido2 = new Sonido("wolfi.wav");
        int movimientodireccion = 1;

        sprite[0][0] = cargaSprite(imagen);
        int posx = 0;
        int posy = 0;
        //  sprite[0][0]=sprite[0][0].getSubimage(0, 0, 45, 45);
        for (int z = 1; z <= 3; z++) {
            for (int za = 1; za <= 4; za++) {


                sprite[z][za] = sprite[0][0].getSubimage(posx, posy, 50, 50);

                posx = posx + 50;

            }
            posx = 0;
            posy = posy + 50;

        }

        for (int z = 1; z <= 4; z++) {
            posy = 150;
            sprite[4][z] = sprite[0][0].getSubimage(posx, posy, 50, 49);
            posx = posx + 50;

        }
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

    public void update(int Nivelobo) {

    switch(estado)
    {
        case vivo:

if(muerto)
{
    x=-10;
    y=200;
}

//ContadorMovimento++;
        if(hp<=0)
            muerto=true;

    //   movimientodireccion=3;
        if(iniciolobo){
        if(Nivelobo==1)
           hp=hpnivel1;
        else
          hp=hpnivel2;

        if(iniciolobo)
            iniciolobo=false;
        }



      
if(Nivelobo==2){//lobo de nivel 2 usa aullido
        Contadoraullido++;//para aullido
        if (Contadoraullido == 3500) {
            sonido2.reproducir();
            Contadoraullido = 0;
            Llamarayuda = true;
        } else {
            Llamarayuda = false;
        }//para aullido
        }

        
        
        switch (movimientodireccion) {
            case 1:
                MovimientoGif = 1;
                if (y <= 555) {
                    y++;
                    y++;  
                    
                }
                break;
            case 2:
                MovimientoGif = 2;
                if (x >= 0) {
                    x--;
                    x--; x--;  x--; x--;
                    x--;
                }
                break;
            case 3:
                MovimientoGif = 3;
                if (x <= 770) {
                    x++;
                    x++;
                    x++;
                    x++; x++;
                    x++;
                }

                break;
            case 4:
                MovimientoGif = 4;
                if (y >= 0) {
                    y--;y--;
               
                }
                break;

        }
         randomValue1 = Math.random();
            randomValue1 = randomValue1 * 1000;
        if (ContadorMovimento == 1)
            movimientodireccion = movimientodireccioncomprobar(randomValue1);
        if (ContadorMovimento == 100) {
            ContadorMovimento = 0;
           // sonido.reproducir();
        }
        ContadorMovimento++;
        movergif(ContadorMovimento);


       

        rectangulo = new Rectangle(x , y, 40, 50);
        break;
        case muerto:
        case inactivo:
            rectangulo= new Rectangle(0,0,0,0);
        break;
        }


    }

    public int movergif(int contadorgi) {

        if (contadorgi <= 20)// contador una variable para modificar el gif
        {
            MovimientoAct = 1;
        }
        if (contadorgi == 40) {
            MovimientoAct = 2;
        }
        if (contadorgi == 60) {
            MovimientoAct = 3;
        }
        if (contadorgi == 80) {
            MovimientoAct = 4;
        }


        return MovimientoAct;
    }

    public int movimientodireccioncomprobar(double Value1) {//para la direccion del enemigo
        int movimientoarana = 0;
        if (Value1 <= 250) {
            movimientoarana = 1;
        } else if (Value1 <= 500) {
            movimientoarana = 2;
        } else if (Value1 <= 750) {
            movimientoarana = 3;
        } else {
            movimientoarana = 4;
        }
        System.out.println(movimientoarana);
        return movimientoarana;

    }

    public void paint(Graphics g) {

        switch(estado)
        {
            case vivo:

        g.drawImage(sprite[MovimientoGif][MovimientoAct], x, y, this);

//g.drawRect(x, y, 50, 49);
break;
            case inactivo:
            case muerto:
                break;
        //g.drawImage(sprite, x, y, this);
        //  g.fillOval(x,y,50,50);
    }}
}
