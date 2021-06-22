package Grafico;
import Utils.Constantes;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import Grafico.Fuego;
import Grafico.Fondo;
import Audio.Sonido;


public class Laiker extends Actor{
private Sonido sonido;
    public boolean DesplazarPx=false;
     private ArrayList lasers;
     boolean findeljuego=false;
  //  Fuego f=new Fuego(x,y);
    ArrayList<Fuego> fuego;
ArrayList<Fuego>fuegoAux;
//private Fuego  fuego;
//Fuego fuego=new Fuego(x,y);
  //  private ArrayList fuego;
private ArrayList sprites;
public boolean    fuegoBanderaInicio=false;
public  boolean ActivarFuego=false;//para inicializar bala
public boolean ActivarAtaque1=false;
int contadormuerto=0;
//sprites=new ArrayList();

//sprites.add("img/fuegoPoder.png");
   // private ArrayList<Fuego> f;
 // Fuego fu= f.get(1);
  


int InicioBolitaX=700;
    int InicioBolitaY=100;
 Boolean   BanderaInicio=true;
Rectangle rectangulo1=new Rectangle(700+x,50+y,50,50);
Enemigo Arana;//llamamos al enemigo
 public int a=0;//para inicializar bala
public int b=0;//para inicializar bala

 int MovimientoGif=0;
    int MovimientoAct=0;
    int ContadorGif=0;


       public void setBolita(Rectangle rectangulo1) {
           this.rectangulo1 = rectangulo1;
    }





          public Rectangle getBolita() {
           return rectangulo1;
    }



          public boolean getFindeljuego() {
              return findeljuego;
          }



          public int getMovimientogif() {
              return MovimientoGif;
          }

    public Laiker(String imagen){



        //w=32 h=43
        super(imagen);

x=800;
y=50;
        
      //  sonido=new Sonido("C:/Users/laiker/Documents/usb250/no borrar/pooa4/grito.wav");
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
           //    sprite[0][1]=sprite[0][1].getSubimage(119, 0, 119, 109);
       //           sprite[0][2]=sprite[0][2].getSubimage(250, 0, 150, 109);
    //sprite[0][3]=sprite[0][3].getSubimage(250, 0, 150, 109);


           //  sprite[1][0]=sprite[2][10].getSubimage(0, 180, 110, 90);
           //    sprite[1][1]=sprite[2][10].getSubimage(119, 180, 119, 90);
            //      sprite[1][2]=sprite[2][10].getSubimage(250, 180, 150, 90);

               //    sprite[3][0]=sprite[2][10].getSubimage(0, 270, 110, 80);
            //   sprite[3][1]=sprite[2][10].getSubimage(119, 270, 119, 80);
            //      sprite[3][2]=sprite[2][10].getSubimage(250, 270, 150, 80);
    }
       
    public ArrayList getLasers(){
      return lasers;
  }
    public Laiker()
    {

         y = 50;
      x = 150;
         lasers = new ArrayList();
    }



    public Laiker(int x,int y){
        this.x = x;
        this.y = y;
        fuego = new ArrayList();
    }

 public ArrayList getFuego(){
      return fuego;
  }



    public void update(int teclas, boolean coalision, boolean coalisionpared,boolean coalisionparedi , boolean coalisionpared2, boolean ataque1verficar,boolean fuegoenuso,boolean aranamuerta1,boolean noi, boolean nod,boolean noa) throws InterruptedException{
System.out.println(fuegoenuso+"fuego");
System.out.println(teclas+ "teclas" );
if(coalision)
findeljuego=true;

        if(ActivarAtaque1)
    ActivarAtaque1=false;

         
        if(  DesplazarPx)
            DesplazarPx=false;
 
//       if(rectangulo1.intersects(Arana.getEnemigo()))
    //   {

     //       x=0;
     //       y=0;
     //  }
ContadorGif++;
            ContadorGif++;
             ContadorGif++;




     //    if(Bolita.class.getRec().Intersect(enemigo.getRec)){

 //  Rectangle rectangulo1=new Rectangle(x,y,10,10);


  //rectangulo1.intersects(Enemigo.);
 //if(Bolita.class.getRec().Intersect(Enemigo.getRec))
  //        rectangulo1.intersects(rectangulo2);
       
      //Rectangule rec=new Rectangule(4,5,11,12);
         if(!coalisionpared)                
            if((teclas & _UP) != 0)
            {
               if(!noa)
                y-= (y>0?_DESPY:0);
                               MovimientoGif=3;     //    x++; 3 arriba,0 abajo,1 izquierda, 2 derecha
           ContadorGif++;
            ContadorGif++;
             ContadorGif++;

         if( ContadorGif>=20)
              MovimientoAct=0;
         if(ContadorGif>=40)
             MovimientoAct=1;
        if(ContadorGif>=60)
            MovimientoAct=2;
if(ContadorGif>=80)
ContadorGif=0;

                
        }
            if((teclas & _DOWN)!= 0)
        {
                     MovimientoGif=0;
                y+= (y<LARGO-65?_DESPY:0);
                     ContadorGif++;
                      ContadorGif++; ContadorGif++;

         if( ContadorGif>=20)
              MovimientoAct=0;
         if(ContadorGif>=40)
             MovimientoAct=1;
         if(ContadorGif>=60)
             MovimientoAct=2;
if(ContadorGif>=80)
ContadorGif=0;
        }
         System.out.println("");
         
          if(!coalisionparedi && !coalisionpared2 &&!noi)
            if((teclas & _LEFT) != 0)
            {
                       MovimientoGif=1;     //    x++;
           ContadorGif++;
            ContadorGif++;
             ContadorGif++;
         if( ContadorGif>=20)
              MovimientoAct=0;
         if(ContadorGif>=40)
             MovimientoAct=1;
        if(ContadorGif>=60)
            MovimientoAct=2;
if(ContadorGif>=80)
ContadorGif=0;
                x-= (x>0?_DESPX:0);

        }
   if(!nod)
            if((teclas & _RIGHT ) != 0 )
            {
                             MovimientoGif=2;     //    x++;
           ContadorGif++;
            ContadorGif++;
             ContadorGif++;
         if( ContadorGif>=20)
              MovimientoAct=0;
         if(ContadorGif>=40)
             MovimientoAct=1;
        if(ContadorGif>=60)
            MovimientoAct=2;
if(ContadorGif>=80)
ContadorGif=0;
                


 //desplazarpantalla
                if(x>750&& aranamuerta1 )
                    DesplazarPx=true;
                else
                    DesplazarPx=false;

           
           

           if(!DesplazarPx)
               if(x<=750)
             x+= (x<ANCHO-30?_DESPX:0);//para evitar que camine cuando la pantalla se mueva

        }


            if(coalision)
{
                //sonido.reproducir();
    x=500;
    y=500;
}
         if( ActivarAtaque1)
             ActivarAtaque1=false;
if((teclas & _KEY_A )!=0)
{
if(!ataque1verficar)
    ActivarAtaque1=true;
//   Fuego fuegos=new Fuego("img/fuegoPoder.png",300,300);
//lasers.add(new Laser(x , y));
//Fuego f=new Fuego(x,y);


     //fuego.add(new Fuego(10,10));

 //    for(Fuego fu : f)
//{
//     f.remove(fu);

//}
    //Fuego(x,y);
  // for(int z=0;z<5;z++)
  // Thread.sleep(100);
      //  fuegoBanderaInicio=true;

}

if(ActivarFuego)
    ActivarFuego=false;


        

            if((teclas & _KEY_S )!=0)
{
                a=x;
                b=y;
                if(!fuegoenuso){//el fuego se usa hasta que se extinga
                 ActivarFuego=true;
          fuegoBanderaInicio=true;
    }
 //for(Fuego fu : f)
//{
//     f.add(fu);

//}
   
}
 System.out.println(rectangulo1.getLocation()+"Actor");

//       if(rectangulo1.intersects(Arana.getEnemigo()))
   //    {

      //      x=0;
      //      y=0;
       //}


       /*     if((teclas & _KEY_A) != 0){
                Date tiempo = new Date();
                if(((tAux=tiempo.getTime())-tiempoDisparo)){
                    disparar(0);
                    tiempoDisparo = tAux;
                }
        
        if(dirVertical==0)
        {
            x++;
            if(x==ancho-30)
                dirVertical = 1;
        }
        else
        {
            x--;
            if(x==0)
                dirVertical = 0;
        }
        if(dirHorizontal==0)
        {
            y++;
            if(y==largo-30)
                dirHorizontal = 1;
        }
        else
        {
            y--;
            if(y==0)
                dirHorizontal = 0;
        }*/


 rectangulo1=new Rectangle(x,y,50,50);
 if(BanderaInicio==true)
{
    x=InicioBolitaX;
    y=InicioBolitaY;
    BanderaInicio=false;
}
    }

    public void paint(Graphics g){
 switch(estado)
 {
     case vivo:
        // g.setColor(Color.RED);
           g.drawImage(sprite[MovimientoGif][ MovimientoAct], x, y, this);
           break;
     case dano:

         break;


     case muerto:
                 contadormuerto++;
         switch (contadormuerto){
             case 1:
                 g.drawRect(x, y, 40, 40);break;
             case 2: g.drawRect(x, y, 30, 30);break;
             case 3:
                 g.drawRect(x, y, 20, 20);break;
             case 4:
                g.drawRect(x, y, 10, 10);break;



         }
        }
          
      //  g.setColor(Color.RED);
      //  g.fillOval(x,y,30,30);
         //g.drawImage(sprite, x, y, this);
    }

}
