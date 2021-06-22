
package Logica;
import javax.swing.JFrame;
public class Laikers extends JFrame {
   public static void main(String[] args) throws InterruptedException{
      Laikers ventana = new Laikers();
      Juego j = new Juego();
      ventana.add(j); // introducir juego en ventana
      ventana.setVisible(true); // hacer visible ventana
      j.createDoubleBufferStrategy();
      ventana.setResizable(false); // no se puede cambiar el tamaño de la ventana
      j.init(); // iniciar objetos del juego
      j.loop(); // llamar juego
   }

   public Laikers(){
       this.setSize(805,625);
   }
}


