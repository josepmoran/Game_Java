package Grafico;
import Utils.Constantes;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Canvas;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
public abstract class Actor extends Canvas implements Constantes{
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected estadosEnemigo estado;

    public estadosEnemigo getEstado() {
        return estado;
    }

    public void setEstado(estadosEnemigo estado) {
        this.estado = estado;
    }

 protected int spriteActual[][];
   // protected BufferedImage sprite2;
    public BufferedImage[][] sprite;
    //subimage buscar cone sto
    public Actor(){
        
    }
    public Actor(String imagen){
        sprite= new BufferedImage[6][12];
       sprite[0][0] = cargaSprite(imagen);
      //sprite[0][0].getSubimage(3, 3, 3, 3);
       // h = sprite.getHeight();
       // w = sprite.getWidth();

       // sprite.getSubimage(3, 3, 3, 3);
    }
    public final BufferedImage cargaSprite(String imagen){
        try{
            URL url = getClass().getClassLoader().getResource(imagen);
            return ImageIO.read(url);
        }catch(Exception e){
            return null;
        }
    }
    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
