package gallinaia;

import java.io.Serializable;

public class Obstaculo implements Serializable{
    private final int  posX; 
    private final int posY;
    private final int largo;
    private final int alto;
    
    public Obstaculo(int posX, int posY, int largo, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.largo = largo;
        this.alto = alto;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    public int getLargo() {
        return largo;
    }


    public int getAlto() {
        return alto;
    }
 
}
