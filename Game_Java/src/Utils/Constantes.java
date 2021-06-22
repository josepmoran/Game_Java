package Utils;
public interface Constantes {

   //dimensiones de la ventana del juego
   final static int ANCHO = 1755;
   final static int LARGO = 625;


   // int _DESPY = 1;
 //  int _DESPX = 1;
   final static int _DESPY = 5;
   final static int _DESPX = 5;


   int _LEFT    =  1<<1;
   int _RIGHT   =  1<<2;
   int _DOWN    =  1<<3;
   int _UP      =  1<<4;
   int _KEY_A   =  1<<5;
   int _KEY_S   =  1<<6;
   int _ENTER   =  1<<7;
   int _NONE    =  1<<8;


   public enum estadosEnemigo{
       vivo,muerto,inactivo,dano;
   }

    public enum Niveles{
       Menu,Nivel1,Nivel1a,Nivel2,Gameover;
   }
}








