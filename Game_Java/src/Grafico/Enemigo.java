package Grafico;

import Audio.Sonido;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;
import java.math.RoundingMode;
import java.util.Date;

public class Enemigo extends Actor {

    double randomValue1 = Math.random();
    private estadosEnemigo estado;
    Date tiempo = new Date();
    int InicioAranaX = 0;
    int InicioAranaY = 0;
    boolean BanderaInicio = true;
    int MovimientoGif = 0;
    int MovimientoAct = 0;
    int ContadorMovimento = 0;
    boolean Quitgritodemuerte = true;//para quitar el sonido por arana
    int ContadorGif = 0;
    boolean muerto = false;
    int hp = 10;
    boolean gritodemuerte = false;
    Rectangle rectangulo2 = new Rectangle(x + 50, y, 40, 50);
    private Sonido sonido;
    int movimientoarana = 1;

    public int getInicioAranaX() {
        return InicioAranaX;
    }

    public void setInicioAranaX(int InicioAranaX) {
        this.InicioAranaX = InicioAranaX;
    }

    public int getInicioAranaY() {
        return InicioAranaY;
    }

    public void setInicioAranaY(int InicioAranaY) {
        this.InicioAranaY = InicioAranaY;
    }

    public estadosEnemigo getEstado() {
        return estado;
    }

    public void setEstado(estadosEnemigo estado) {
        this.estado = estado;
    }

    public Rectangle getRectangulo2() {
        return rectangulo2;
    }

    public void setRectangulo2(Rectangle rectangulo2) {
        this.rectangulo2 = rectangulo2;
    }

    public Enemigo(String imagen, int iniciox, int inicioy) {
        super(imagen);
        estado = estado.inactivo;
        InicioAranaX = iniciox;
        InicioAranaY = inicioy;
        sonido = new Sonido("grunido.wav");
        int movimientoarana = 1;
//int randomValue1 = (int) Math.random();

//403 358
        //114
        //119
        //100 y
        sprite[0][0] = cargaSprite(imagen);
        sprite[0][1] = cargaSprite(imagen);
        sprite[0][2] = cargaSprite(imagen);
        sprite[2][10] = cargaSprite(imagen);

        sprite[0][0] = sprite[0][0].getSubimage(0, 0, 110, 100);
        sprite[0][1] = sprite[0][1].getSubimage(119, 0, 119, 109);
        sprite[0][2] = sprite[0][2].getSubimage(250, 0, 150, 109);


        sprite[1][0] = sprite[2][10].getSubimage(0, 180, 110, 90);
        sprite[1][1] = sprite[2][10].getSubimage(119, 180, 119, 90);
        sprite[1][2] = sprite[2][10].getSubimage(250, 180, 150, 90);

        sprite[3][0] = sprite[2][10].getSubimage(0, 270, 110, 80);
        sprite[3][1] = sprite[2][10].getSubimage(119, 270, 119, 80);
        sprite[3][2] = sprite[2][10].getSubimage(250, 270, 150, 80);

        sprite[4][0] = sprite[2][10].getSubimage(0, 90, 110, 80);
        sprite[4][1] = sprite[2][10].getSubimage(119, 90, 119, 80);
        sprite[4][2] = sprite[2][10].getSubimage(250, 90, 150, 80);

    }

    public void setEnemigo(Rectangle rectangulo2) {
        this.rectangulo2 = rectangulo2;
    }

    public Rectangle getEnemigo() {
        return rectangulo2;
    }

    public boolean getMuerto() {
        return muerto;
    }

    // public Enemigo(int x,int y){
    //    this.x= x;
    //    this.y = y;
    // }
    public int movimientoaranacomprobar(double Value1) {
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

    public void update(boolean DesplazarX, boolean DanoSlash, boolean DanoFuego, int tipoarana, boolean noavanzarArriba, boolean noavanzarIzquierda) {
        //int movimientoarana=1;


        switch (estado) {
            case vivo:

                ContadorMovimento++;
                randomValue1 = randomValue1 * 1000;
//<Inicio de arana>



                if (ContadorMovimento >= 80) {

                    System.out.println("arriba,abajo" + randomValue1);
                    ContadorMovimento = 0;
                    movimientoarana = movimientoaranacomprobar(randomValue1);

                }
                System.out.println("\n" + ContadorMovimento + "contador  1-30");

                System.out.println("\n" + movimientoarana + "moviento actual  1m2,3,4");
                // tiempoDisparo = tAux;
                //    }




                if (hp <= 0) {
                    muerto = true;
                    gritodemuerte = true;
                    y = 1000;




                }







                if (DanoSlash) {

                    hp = hp - 20;
                }

                if (DanoFuego) {

                    hp = hp - 1;
                }

                System.out.println(rectangulo2.getLocation() + "enemigo");
                //  Rectangle rectangulo2=new Rectangle(x,y,10,10);
                if (DesplazarX) {
                    if(x<50)
                    x--;
                }
                if (BanderaInicio == true) {
                    // InicioAranaX=200;
                    y = InicioAranaY + y;
                    BanderaInicio = false;
                } //</Inicio de arana>
                else {
//InicioAranaX=0;
                    if (y == 0) {
                        BanderaInicio = true;
                    } else {
                        switch (movimientoarana) {
                            case 2: //<abajo>//////MovimientoGif 0
                                MovimientoGif = 0;

                                y++;
                                ContadorGif++;
                                if (ContadorGif == 20) {
                                    MovimientoAct = 0;
                                }
                                if (ContadorGif == 40) {
                                    MovimientoAct = 1;
                                }
                                if (ContadorGif == 60) {
                                    MovimientoAct = 2;
                                }
                                if (ContadorGif == 80) {
                                    ContadorGif = 0;
                                }
                                break;
                            case 1:
                                //<derecha>//////MovimientoGif 1
                                MovimientoGif = 1;
                                if (x <= 755) {
                                    x++;
                                    x++;
                                    x++;

                                }

                                ContadorGif++;
                                if (ContadorGif == 20) {
                                    MovimientoAct = 0;
                                }
                                if (ContadorGif == 40) {
                                    MovimientoAct = 1;
                                }
                                if (ContadorGif == 60) {
                                    MovimientoAct = 2;
                                }
                                if (ContadorGif == 80) {
                                    ContadorGif = 0;
                                }


                                //</derecha>//////MovimientoGif 1
                                break;
                            case 3:

                                //<Izquiera>//////MovimientoGif 2
                                MovimientoGif = 4;
                                if (x>50) {
                                    x--;
                                    x--;
                                    x--;
                                }

                                ContadorGif++;
                                if (ContadorGif == 20) {
                                    MovimientoAct = 0;
                                }
                                if (ContadorGif == 40) {
                                    MovimientoAct = 1;
                                }
                                if (ContadorGif == 60) {
                                    MovimientoAct = 2;
                                }
                                if (ContadorGif == 80) {
                                    ContadorGif = 0;
                                }
                                break;

                            case 4:

                                MovimientoGif = 3;
                                if (!noavanzarArriba) {
                                    y--;
                                    y--;
                                }
                                ContadorGif++;
                                if (ContadorGif == 30) {
                                    MovimientoAct = 0;
                                }
                                if (ContadorGif == 60) {
                                    MovimientoAct = 1;
                                }
                                if (ContadorGif == 80) {
                                    ContadorGif = 0;
                                }
                                break;




                            /*     if((teclas & _KEY_A) != 0){
                            Date tiempo = new Date();
                            if(((tAux=tiempo.getTime())-tiempoDisparo)){
                            disparar(0);
                            tiempoDisparo = tAux;                }

                            }

                            }*/
                        }
                    }
                    rectangulo2 = new Rectangle(x+10 + 50, y+10, 20, 20);
                    System.out.println(100 * randomValue1 + "hazar moviiebntoarana" + movimientoarana);
                    randomValue1 = Math.random();

                    //System.out.println(randomValue1);


                }
                break;
            case muerto:
                    rectangulo2 = new Rectangle(0, 0, 0, 0);
                        if (Quitgritodemuerte) {
                        sonido.reproducir();
                        Quitgritodemuerte = false;
                             }
                      
                break;

        }
    }

    public void paint(Graphics g) {

        switch (estado) {
            case vivo:
                g.drawImage(sprite[MovimientoGif][MovimientoAct], x, y, this);
                g.drawRect(x+10 + 50, y+10, 20, 20);
                //g.drawImage(sprite, x, y, this);
                //  g.fillOval(x,y,50,50);
                break;

        }
    }
}
