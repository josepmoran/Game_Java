package Logica;

import Audio.MusicaFondo;
import Audio.Sonido;

import Entrada.Key;
import Grafico.Gameover;
import Grafico.Laiker;
import Grafico.Enemigo;
import Grafico.Lobo;
import Grafico.Arbol;
import Grafico.Fondo;
import Grafico.Fuego;
import Grafico.Ataque1;
import Grafico.FuegoPrestonF;
import java.awt.Canvas;
import Grafico.Ataquearbol;
import Grafico.Continuara;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import Grafico.FantasmaPreston;
import Grafico.Instrucciones;
import Grafico.Menu;
import Grafico.Menu2;
import Grafico.Menu3;
//import Logica.Juego.Juegonivel;

import Utils.Constantes.Niveles;
import Utils.Constantes.estadosEnemigo;
import java.util.ArrayList;

public class Juego extends Canvas {

    boolean aparecerlobo1 = false;
//ArrayList  Arboles;
    int TiempoParpadeo = 0;
    boolean Parpadeo = false;
    private Gameover gameover;
    boolean findeljuego = false;
    boolean Iniciofantasma = false;
    private Ataquearbol ataquearbol, ataquearbol1;
    private FuegoPrestonF fpf;
    private FuegoPrestonF fpf2;
    private FuegoPrestonF fpf3;
    private FuegoPrestonF fpf4;
    private FuegoPrestonF fpf5;
    private FuegoPrestonF fpf6;
    private FuegoPrestonF fpf7;
    private FuegoPrestonF fpf8;
    private ArrayList<Enemigo> enemigo2;
    private ArrayList<Lobo> lobos;
    private ArrayList<Lobo> lobos1;
    private ArrayList<Ataquearbol> ataquearboles;
    private ArrayList<Arbol> Arboles;
    private Lobo lobo, lobo1, lobo2, lobo3, lobo4;
    boolean avanzarlobojefe = false;
    private Arbol arbol;
    private FantasmaPreston fp;
    private MusicaFondo musica;
    private MusicaFondo jefe1musica;
    boolean reproducirjefe1 = true;
    private Fondo f;
    private Ataque1 ataque1;
    private Laiker b;
    private Fuego fuego;
    private int w;
    private int h;
    int contadormenu = 1;
//   private Enemigo animal,animal2,animal3;
    private Key keyManager;
    private BufferStrategy strategy;
    private Sonido sonido;
    boolean detenermusica = true;
    boolean menu = true;
    boolean Coalision = false;
    boolean CoalisionPared = false;
    boolean CoalisionPared2 = false;
    boolean CoalisionParedI = false;
    boolean RI1 = false;//escaleraizquierdopilar
    boolean RI2 = false;//escaleraizquierdopilar
    boolean RI3 = false;//escaleraizquierdopilar
    boolean RD1 = false;//escaleraderechapilar
    boolean RD2 = false;//escaleraderechapilar
    boolean RD3 = false;//escaleraiderechapilar
    boolean iniciodeljuego = true;
    //observa si las aranas estanmuertasb
    boolean desplazarpantalla = false;
//lobos
    boolean activarlobos1 = false;
    boolean activarlobos0 = false;
    boolean muertolobo = false;
    boolean aparecelobo = false;
    boolean aparecelobo1 = false;
    boolean aparecelobo2 = false;
    boolean aparecelobo3 = false;
    boolean aparecelobo4 = false;
    boolean activararboles = false;
    boolean danolaiker = false;
    boolean activarmusica1jefe = true;
    boolean borraArbol = false;
    boolean Nivel2 = false;
    int Niveles = 1;
    int contadorteclado = 0;
    private Menu menu1;
    private Menu2 menu2;
    private Menu3 menu3;
    private Instrucciones instrucciones;
    boolean instruccionesbandera = false;

    private Continuara continuara;
    //  private int Juegonivel;
    //private enum Juegoni {  Menu,Nivel1,Nivel1a,Nivel2;}

    //  int Iniciob=150;
    public void loop() throws InterruptedException {
        while (true) {
            updateWorld();
            paintWorld();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("\nError.");
            }
        }
    }

    public void updateWorld() throws InterruptedException {



        int teclas = 0;
        teclas = keyManager.getKeyPressed();
        int tecla2 = 0;
        teclas = keyManager.getKeyPressed();
        //int Juegonivel;

        if (findeljuego) {
            Niveles = 10;
        }

        switch (Niveles) {
            case 1:
                System.out.print(teclas);
                contadorteclado++;
                if (contadorteclado > 25) {
                    if (teclas == 8) {
                        contadormenu++;
                        contadorteclado = 0;
                    }
                    if (contadormenu > 4) {
                        contadormenu = 1;
                    }
                }
                if (contadormenu == 1 && teclas == 128) {
                    Niveles = 2;
                }
                if (contadormenu == 2 && teclas == 128) {
                    
                    instruccionesbandera = true;
                }

                if (contadormenu == 3 && teclas == 128) {
                    System.exit(0);
                }
                //menu1.update();

                break;

            case 2:


                int despalzarxMatandoaranas = 0;
                boolean golpespada = false;
                boolean golpefuego = false;
                boolean golpespada2 = false;
                boolean golpefuego2 = false;
                boolean golpespada3 = false;
                boolean golpefuego3 = false;



                if (iniciodeljuego) {
                    musica = new MusicaFondo("music.mid");
                    jefe1musica = new MusicaFondo("jefe1.mid");
//                    musica.reproducir();
                    iniciodeljuego = false;
                }


                if (!findeljuego) {


//fin del juego

                    //aqui creo todos los rectangulos y aqui checo coalisiones



                    //arbol






                    for (int z = 0; z < enemigo2.size(); z++) {//aranas cada una con el update
                        if (enemigo2.get(z).getEstado() == estadosEnemigo.vivo && enemigo2.get(z).getEnemigo().intersects(b.getBolita())) {
                            findeljuego = true;
                        }
                        enemigo2.get(z).update(golpespada3, Parpadeo, golpefuego, teclas, f.getFondoArriba().intersects(enemigo2.get(z).getEnemigo()), desplazarpantalla);
                        if (enemigo2.get(z).getEnemigo().intersects(ataque1.getAtaque1()) || enemigo2.get(z).getEnemigo().intersects(fuego.getFuego())) {
                            enemigo2.get(z).setEstado(estadosEnemigo.muerto);
                            //  enemigo2.remove(z);
                        }

                        if (enemigo2.get(z).getEstado() == estadosEnemigo.muerto) {
                            despalzarxMatandoaranas++;
                        }
                        if (enemigo2.size() == despalzarxMatandoaranas) {
                            desplazarpantalla = true;
                        }



                    }

                    if (desplazarpantalla) {
                        for (int z = 0; z < enemigo2.size(); z++) {
                            if (enemigo2.get(z).getEstado() == estadosEnemigo.muerto) {
                                enemigo2.remove(z);
                            }
                        }
                    }

                    //arboles si esta en esta posicion salen
                    if (f.Moverx == 900) {
                        activararboles = true;
                        if (activarmusica1jefe) {
                            activarmusica1jefe = false;
                         //   musica.detener();
                           jefe1musica.reproducir();
                        }

                    }

                    if (activararboles) {
                        for (int z = 0; z < Arboles.size(); z++) {
                            Arboles.get(z).setEstado(estadosEnemigo.vivo);
                        }
                    }



                    if (activararboles) {
                        activararboles = true;
                    }



                    int comprobararbol = 0;
                    for (int z = 0; z < Arboles.size(); z++) {
                        if (Arboles.get(z).getEstado() == estadosEnemigo.muerto || Arboles.get(z).getMuerto()) {
                            comprobararbol++;
                        }
                    }

                    if (comprobararbol == 6) {
                        borraArbol = true;
                    }

                    if (borraArbol) {
                        for (int z = 0; z < Arboles.size(); z++) {
                            Arboles.remove(z);
                            ataquearboles.remove(z);
                        }
                    }

                    if (Arboles.size() < 1 && b.getBolita().intersects(f.getReacnivel2())) {
                        boolean Nivel2 = true;
                        Niveles=3;
                    }



                    for (int z = 0; z < Arboles.size(); z++) {
                        Arboles.get(z).update(b.DesplazarPx, f.getReacfinalderecha().intersects(Arboles.get(z).getEnemigo()));
                    }
//para danar al arbol
                    for (int z = 0; z < Arboles.size(); z++) {
                        if (Arboles.get(z).getEstado() == estadosEnemigo.dano) {
                            Arboles.get(z).setEstado(estadosEnemigo.vivo);

                        }

                    }

                    for (int z = 0; z < Arboles.size(); z++) {


                        if (Arboles.get(z).getEnemigo().intersects(ataque1.getAtaque1()) || Arboles.get(z).getEnemigo().intersects(fuego.getFuego())) {
                            Arboles.get(z).setDano(50);
                            Arboles.get(z).setEstado(estadosEnemigo.dano);

                            System.out.println("arbol danado");
                        } else {
                            Arboles.get(z).setDano(0);
                        }

                    }


                    //para convocar al poder del arbol
                    for (int z = 0; z < Arboles.size(); z++) {
                        if (Arboles.get(z).getbanderataque()) {
                            ataquearboles.get(z).setEstado(estadosEnemigo.vivo);
                        } else {
                            ataquearboles.get(z).setEstado(estadosEnemigo.inactivo);
                        }

                    }
                    //para eliminar alos arboles
                    for (int z = 0; z < Arboles.size(); z++) {
                        if (Arboles.get(z).getMuerto()) {
                            Arboles.get(z).setEstado(estadosEnemigo.muerto);
                        }
                    }




                    for (int z = 0; z < ataquearboles.size(); z++) {
                        ataquearboles.get(z).update(Arboles.get(z).Getdireccionataque(), Arboles.get(z).getX(), Arboles.get(z).getY(), Arboles.get(z).getActivarpoder());
                    }


                    //   if(activararboles){
                    for (int z = 0; z < Arboles.size(); z++) {
                        if (Arboles.get(z).getEnemigo().intersects(b.getBolita()) || ataquearboles.get(z).getEnemigo().intersects(b.getBolita())) {
                            danolaiker = true;
                        }
                    }
                    //  }



                    if (f.Moverx >= 200 && f.Moverx <= 203) {
                        activarlobos0 = true;
                    }




                    if (f.Moverx == 500) {
                        activarlobos1 = true;

                    }
                    if (f.Moverx == 501) {
                        desplazarpantalla = false;
                    }
                    if (avanzarlobojefe) {
                        desplazarpantalla = true;
                    }

                    if (activarlobos1) {
                        lobos.get(0).setEstado(estadosEnemigo.vivo);
                    }

                    if (activarlobos1) {
                        activarlobos1 = false;
                    }


                    for (int z = 1; z < lobos.size(); z++) {
                        lobos.get(0).update(2);
                        lobos.get(z).update(1);
                        if (lobos.get(0).getLlamarayuda()) {
                            for (z = 1; z < lobos.size(); z++) {
                                lobos.get(z).setEstado(estadosEnemigo.vivo);
                            }
                        }
                        if (lobos.get(0).getEnemigo().intersects(ataque1.getAtaque1()) || lobos.get(0).getEnemigo().intersects(fuego.getFuego())) {
                            lobos.get(0).setEstado(estadosEnemigo.muerto);
                            desplazarpantalla = true;
                            avanzarlobojefe = true;
                        }

                        if (lobos.get(0).getEnemigo().intersects(b.getBolita())) {
                            danolaiker = true;
                        }

                    }

                    for (int z = 1; z < lobos.size(); z++) {
                        if (lobos.get(z).getEnemigo().intersects(ataque1.getAtaque1()) || lobos.get(z).getEnemigo().intersects(fuego.getFuego())) {
                            lobos.get(z).setEstado(estadosEnemigo.muerto);
                        }


                        if (lobos.get(z).getEnemigo().intersects(b.getBolita())) {
                            danolaiker = true;
                        }
                    }


                    for (int z = 0; z < lobos.size(); z++) {
                        if (lobos.get(z).getEstado() == estadosEnemigo.vivo) {
                            if (lobos.get(z).getEnemigo().intersects(ataque1.getAtaque1()) || lobos.get(z).getEnemigo().intersects(fuego.getFuego())) {
                                lobos.get(z).setEstado(estadosEnemigo.muerto);
                            }
                        }
                    }

                    for (int z = 0; z < lobos1.size(); z++) {
                        lobos1.get(z).update(1);
                    }
                    for (int z = 0; z < lobos1.size(); z++) {
                        if (activarlobos0) {
                            lobos1.get(z).setEstado(estadosEnemigo.vivo);
                        }
                    }

                    activarlobos0 = false;


                    for (int z = 0; z < lobos1.size(); z++) {
                        if (lobos1.get(z).getEstado() == estadosEnemigo.vivo) {
                            if (lobos1.get(z).getEnemigo().intersects(ataque1.getAtaque1()) || lobos1.get(z).getEnemigo().intersects(fuego.getFuego())) {
                                lobos1.remove(z);
                            }
                        }
                    }


                    if (f.Moverx == 204) {
                        desplazarpantalla = false;
                        if (lobos1.size() < 1) {
                            desplazarpantalla = true;
                        }
                    }

                    //  if(lobos.get(0).getEstado()==estadosEnemigo.muerto)











                    //  Arboles.add(arbol2);


                    //arbol


                    //lobo
  /*
                    if( aparecelobo)
                    lobo.update(2);

                    if(lobo.getLlamarayuda()){

                    //  if(aparecelobo1=false)
                    aparecelobo1=true;
                    //  if(aparecelobo2=false)
                    aparecelobo2=true;
                    //if(aparecelobo3=false)
                    aparecelobo3=true;
                    //if(aparecelobo4=false)
                    aparecelobo4=true;


                    }

                    if(aparecelobo1)
                    lobo1.update(1);

                    if(aparecelobo2)
                    lobo2.update(1);

                    if(aparecelobo3)
                    lobo3.update(1);

                    if(aparecelobo4)
                    lobo4.update(1);
                    //lobos


                     */





                    if (b.getBolita().intersects(f.getFondoIzquierda())) {
                        CoalisionParedI = true;
                    } else {
                        CoalisionParedI = false;
                    }


                    if (b.getBolita().intersects(f.getFondoArriba2())) {
                        CoalisionPared2 = true;
                    } else {
                        CoalisionPared2 = false;
                    }




                    if (b.getBolita().intersects(f.getFondoArriba())) {
                        CoalisionPared = true;
                    } else {
                        CoalisionPared = false;
                    }

                    if (b.getBolita().intersects(f.getReacEscaleraD1()) || b.getBolita().intersects(f.getReacEscaleraI1())) {
                        RI1 = true;
                    } else {
                        RI1 = false;
                    }

                    if (b.getBolita().intersects(f.getReacEscaleraD2()) || b.getBolita().intersects(f.getReacEscaleraI2())) {
                        RI2 = true;
                    } else {
                        RI2 = false;
                    }


                    if (b.getBolita().intersects(f.getReacEscaleraD3()) || b.getBolita().intersects(f.getReacEscaleraI3())) {
                        RI3 = true;
                    } else {
                        RI3 = false;
                    }


                    /*    if(b.getBolita().intersects(animal.getEnemigo())||b.getBolita().intersects(animal2.getEnemigo())||b.getBolita().intersects(animal3.getEnemigo()))
                    {

                    Coalision=true;
                    System.out.println("coalision");
                    }
                    else
                    Coalision=false;

                     */

                    if (b.fuegoBanderaInicio) {
                        fuego.update(b.fuegoBanderaInicio, teclas, b.ActivarFuego);
                        //   sonido.reproducir();
                        //_DESPY++;
                    }
//if(animal.getMuerto()&&animal2.getMuerto()&&animal3.getMuerto())
                    //  Aranasmuertas=true;
                    b.update(teclas, Coalision, CoalisionPared, CoalisionParedI, CoalisionPared2, ataque1.getBanderaataque(), fuego.getFuegoenuso(), desplazarpantalla, RI1, RI2, RI3);

                    //   if(f.Moverx>=1785||aparecelobo)
                    //         b.DesplazarPx=false;
                    if (f.Moverx >= 950) {
                        desplazarpantalla = false;
                        b.DesplazarPx = false;
                    }

                    f.update(b.DesplazarPx);
                    /*    if(! Aranasmuertas){
                    //animal(recibe desplazar fondo,golpes,golpe,numero de comportamiento,intesersccion de fondo arriba, interseccion de fondo izquierod
                    if(!animal.getMuerto())animal.update(b.DesplazarPx,golpespada,golpefuego, 1,animal.getEnemigo().intersects(f.getFondoArriba()),animal.getEnemigo().intersects(f.getFondoIzquierda()));
                    if(!animal2.getMuerto())        animal2.update(b.DesplazarPx,golpespada2,golpefuego2, 1,animal2.getEnemigo().intersects(f.getFondoArriba()),animal2.getEnemigo().intersects(f.getFondoIzquierda()));
                    if(!animal3.getMuerto())       animal3.update(b.DesplazarPx,golpespada3,golpefuego3, 1,animal3.getEnemigo().intersects(f.getFondoArriba()),animal3.getEnemigo().intersects(f.getFondoIzquierda()));
                    }*/


                    ataque1.update(b.getX(), b.getY(), b.getMovimientogif(), b.ActivarAtaque1);
                    if (Iniciofantasma) {
                        Iniciofantasma = false;
                    }

                    if (f.getPosicion() >= 500 && f.getPosicion() <= 600) {
                        Iniciofantasma = true;
                    }




                    //  if(Iniciofantasma){
                    //      fp.update();
                    //      fpf.update(0,100);
                    //      fpf2.update(0,200);
                    //      fpf3.update(550,330);
                    //      fpf4.update(500,400);
                    //       fpf5.update(500,500);
                    //       fpf6.update (500,250);
                    //       fpf7.update(150,150);
                    //       fpf8.update(100,500);
                    //  }


                    //logica de lobos por elimanirlo
//          if(lobo.getEnemigo().intersects(fuego.getFuego())||lobo.getEnemigo().intersects(ataque1.getAtaque1())){
                    //          aparecelobo=false;
                    //   muertolobo=true;
                    //    }

                    //    if(lobo1.getEnemigo().intersects(fuego.getFuego())||lobo1.getEnemigo().intersects(ataque1.getAtaque1()))
                    //          aparecelobo1=false;
                    //    if(lobo2.getEnemigo().intersects(fuego.getFuego())||lobo2.getEnemigo().intersects(ataque1.getAtaque1()))
                    //          aparecelobo2=false;
                    //    if(lobo3.getEnemigo().intersects(fuego.getFuego())||lobo3.getEnemigo().intersects(ataque1.getAtaque1()))
                    //        aparecelobo3=false;
                    //   if(lobo4.getEnemigo().intersects(fuego.getFuego())||lobo4.getEnemigo().intersects(ataque1.getAtaque1()))
                    //        aparecelobo4=false;

//        if(b.getBolita().intersects(fpf6.getFpf())||b.getBolita().intersects(fpf8.getFpf())||b.getBolita().intersects(fpf7.getFpf())||b.getBolita().intersects(fpf.getFpf())||b.getBolita().intersects(fpf.getFpf())||b.getBolita().intersects(fpf2.getFpf())||b.getBolita().intersects(fpf3.getFpf())||b.getBolita().intersects(fpf4.getFpf())||b.getBolita().intersects(fpf5.getFpf()));
                    //     System.out.println("auch");

                    if (danolaiker) {
                        findeljuego = true;
                    }
                    if (b.getFindeljuego()) {
                        findeljuego = true;
                    }

                    if (f.Moverx >= 210) {

                        aparecelobo = true;
                        if (muertolobo) {
                            aparecelobo = false;
                        }

                    }
                } else {
                    //  if( detenermusica){
                    //    musica.detener();
                    //    detenermusica=false;
                }

                break;
            case 3:
                System.out.println("continuara");
                break;
            case 10:
                System.out.print("fin del juegi");
                if (teclas == 16) {
                    Niveles = 1;
                    System.out.print("Arriba presionado");
                    findeljuego = false;
                }

                break;

        }

    }

    public void createDoubleBufferStrategy() {
        this.createBufferStrategy(2);
        strategy = this.getBufferStrategy();
    }

    public void paintWorld() {

        Graphics g = strategy.getDrawGraphics();

        switch (Niveles) {
            case 1:

                switch (contadormenu) {
                    case 1:
                        menu1.paint(g);
                        break;
                    case 2:
                        menu2.paint(g);

                        if (instruccionesbandera) {
                            instrucciones.paint(g);
                        }

                        break;
                    case 3:
                        menu3.paint(g);
                        break;
                }

                break;

            case 2:


                if (!findeljuego) {

                    f.paint(g);
                    b.paint(g);

//       arbol.paint(g);

                    for (int z = 0; z < enemigo2.size(); z++) {
                        enemigo2.get(z).paint(g);
                    }

                    for (int z = 0; z < lobos.size(); z++) {
                        lobos.get(z).paint(g);
                    }

                    for (int z = 0; z < lobos1.size(); z++) {
                        lobos1.get(z).paint(g);
                    }

                    for (int z = 0; z < Arboles.size(); z++) {
                        Arboles.get(z).paint(g);
                    }

                    for (int z = 0; z < ataquearboles.size(); z++) {
                        ataquearboles.get(z).paint(g);
                    }



                    /*  if(aparecelobo)
                    lobo.paint(g);
                    if(aparecelobo1)
                    lobo1.paint(g);
                    if(aparecelobo2)
                    lobo2.paint(g);
                    if(aparecelobo3)
                    lobo3.paint(g);
                    if(aparecelobo4)
                    lobo4.paint(g);
                     */


                    //   if(!animal.getMuerto()) animal.paint(g);
                    //  if(!animal2.getMuerto()) animal2.paint(g);
                    //   if(!animal3.getMuerto()) animal3.paint(g);
                    if (b.fuegoBanderaInicio) {
                        fuego.paint(g, b.a, b.b, b.ActivarFuego);
                    }
                    ataque1.paint(g);
//       fp.paint(g);
     /*  if(Iniciofantasma){//ataca el fantasma
                    fpf.paint(g);
                    fpf2.paint(g);
                    fpf3.paint(g);
                    fpf4.paint(g);


                    fpf5.paint(g);

                    fpf6.paint(g);

                    fpf7.paint(g);

                    fpf8.paint(g);

                    }*/



                }

                break;

            case 3:
                continuara.paint(g);break;
            case 10:
                gameover.paint(g);

                // if(keymanager=.)
                break;
        }
        // animal.paint(g.drawImage(sprite[0][0]));
        strategy.show();


    }

    public void init() {


        w = 800;
        h = 600;
        //ataque arbol




        //lobos
        f = new Fondo("Img/Dibujo1.jpg");
        b = new Laiker("img/laikergif_1.png");
        b.setEstado(estadosEnemigo.vivo);

        fpf = new FuegoPrestonF("img/FuegoPF.png");

        enemigo2 = new ArrayList<Enemigo>();
        lobos = new ArrayList<Lobo>();
        lobos1 = new ArrayList<Lobo>();
        Arboles = new ArrayList<Arbol>();
        ataquearboles = new ArrayList<Ataquearbol>();


        for (int z = 0; z < 6; z++) {
            Arboles.add(new Arbol("img/arbol.png", z * 100 + 100, z * 100 + 20));
        }

        for (int z = 0; z < Arboles.size(); z++) {
            Arboles.get(z).setEstado(estadosEnemigo.inactivo);
        }

        for (int z = 0; z < 6; z++) {
            ataquearboles.add(new Ataquearbol("img/ataquearbol.png", 0, 0));
        }

        for (int z = 0; z < ataquearboles.size(); z++) {
            ataquearboles.get(z).setEstado(estadosEnemigo.inactivo);
        }

        for (int z = 0; z < 5; z++) {
            enemigo2.add(new Enemigo("img/arana.png", z * 100 + 100, z * 100 + 100));
        }


        for (int z = 0; z < 10; z++) {
            lobos.add(new Lobo("Img/wolfi.png", z * 80, -10));
        }

        for (int z = 0; z < 10; z++) {
            lobos1.add(new Lobo("Img/wolfi.png", z * 80, -10));
        }


        for (int z = 0; z < enemigo2.size(); z++) {
            if (enemigo2.get(z).getEstado() == estadosEnemigo.inactivo) {
                enemigo2.get(z).setEstado(estadosEnemigo.vivo);
            }
        }


        for (int z = 0; z < lobos.size(); z++) {
            lobos.get(z).setEstado(estadosEnemigo.inactivo);
        }

        for (int z = 0; z < lobos1.size(); z++) {
            lobos1.get(z).setEstado(estadosEnemigo.inactivo);
        }





        
    
        arbol = new Arbol("img/arbol.png", 500, 500);
        ataquearbol = new Ataquearbol("Img/ataquearbol.png", arbol.getX(), arbol.getY());
        ataquearbol1 = new Ataquearbol("Img/ataquearbol.png", arbol.getX(), arbol.getY());

        fuego = new Fuego("img/fuegoPoder.png", 300, 300);
        ataque1 = new Ataque1("img/slachataque2_1.png", 100, 100);

        instrucciones = new Instrucciones("img/instrucciones.jpg");
        continuara=new Continuara("img/continuara.jpg");

        gameover = new Gameover("Img/gameover.png");

        menu1 = new Menu("Img/menulaiker1.jpg");

        menu2 = new Menu2("Img/menulaiker2.jpg");
        menu3 = new Menu3("Img/menulaiker3.jpg");

        keyManager = new Key();      //teclas

        addKeyListener(keyManager);  //teclas





    }
}
//math.random entre 0 1, y ese lo multiplicas lo que quieres

