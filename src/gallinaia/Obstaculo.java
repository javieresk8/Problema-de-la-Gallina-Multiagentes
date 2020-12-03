package gallinaia;

import java.io.Serializable;

public class Obstaculo implements Serializable{
    private int  posX; 
    private int posY;
    private int largo;
    private int alto;
    
    public Obstaculo(int posX, int posY, int largo, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.largo = largo;
        this.alto = alto;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    
    
    
    
}
