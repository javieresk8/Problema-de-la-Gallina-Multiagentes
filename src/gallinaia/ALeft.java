/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinaia;

import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uuse
 */
public class ALeft extends Agent{
        @Override
    protected void setup() {
        super.setup();
        addBehaviour(new Comportamiento());
    }

    public class Comportamiento extends Behaviour {
        boolean done = false;
        int indice = 0;
        int sigSalida = 0;
        int accum = 0;
        int posXInicial = juego.getPosX();
        Obstaculo obstaculo ;
        public void moverIzquierda() {
            try {
                Thread.sleep(200);
                int posGallinaY = juego.getPosX();
                juego.desplazarX(-5);
                 System.out.println("aumento posicion en X" + juego.getPosX());
            } catch (InterruptedException ex) {
                Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        public void verificarDistancia(){
//            
//        }

        @Override
        public void action() {
            switch (indice){
                case 0:
                    ACLMessage acl = blockingReceive();
            
                    try {
                        obstaculo = (Obstaculo)acl.getContentObject();
                    } catch (UnreadableException ex) {
                        Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                    indice = 1;
                    break;
                case 1:
                    accum += 5;
                    sigSalida = obstaculo.getLargo() - posXInicial +20;
                    System.out.println(String.format("La posicion de gallina es %d y la del obs es %d", posXInicial, obstaculo.getPosX()));
                    if ( sigSalida > accum){
                        moverIzquierda();
                    } else{
                        juego.avanzarGallina(-6);
                        
                        indice = 2;
                        System.out.println("la gallina avanzo pa lante");
                    }
                    break;
                    
                case 2:
                    EnviarMensaje.enviarMensajeString(ACLMessage.INFORM, "AForward", getAgent(), "Listo", "COD_ALef_AForw");
                    doDelete();
                    
                    
            }
            
            
               
                

                
            

        }

        @Override
        public boolean done() {
            return done;
        }
        
    }
    
}
