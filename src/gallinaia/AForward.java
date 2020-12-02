/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinaia;

import View.Juego;
import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JLabel;

/**
 *
 * @author uuse
 */
public class AForward extends Agent {
    

    @Override
    public synchronized void waitUntilStarted() {
        super.waitUntilStarted(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setup() {
        super.setup();
        System.out.println("forward creado...");
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            try {
                
                ACLMessage acl = receive();
                System.out.println(acl);
                if (acl == null){
                    Thread.sleep(500);
                    int posGallinaY = juego.getPosY();
                    posGallinaY +=5;
                    juego.avanzarGallina(-5);
                    System.out.println("aumento posicion" + juego.getPosY());
                    System.out.println(acl.toString()+ "---------------------------------");
                } else block();
                    
                
            } catch (Exception e) {
            }
            
            
        }
        
    }
}
