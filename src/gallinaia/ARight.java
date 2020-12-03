package gallinaia;

import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ARight extends Agent {

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
        int posXInicial;
        Obstaculo obstaculo ;
        public void moverDerecha() {
            try {
                Thread.sleep(200);
                int posGallinaY = juego.getPosX();
                juego.desplazarX(5);
                 System.out.println("aumento posicion en X" + juego.getPosX());
            } catch (InterruptedException ex) {
                Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void verificarDistancia(){
            
        }

        @Override
        public void action() {
            switch (indice){
                case 0:
                    ACLMessage acl = blockingReceive();
                    posXInicial = juego.getPosX();
                    try {
                        obstaculo = (Obstaculo)acl.getContentObject();
                    } catch (UnreadableException ex) {
                        Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                    indice = 1;
                    break;
                case 1:
                    accum += 5;
                    sigSalida = obstaculo.getLargo()- posXInicial +20;
                    if ( sigSalida > accum){
                        moverDerecha();
                    } else{
                        juego.avanzarGallina(-6);
                        
                        indice = 2;
                        System.out.println("la gallina avanzo pa lante");
                    }
                    break;
                    
                case 2:
                    EnviarMensaje.enviarMensajeString(ACLMessage.INFORM, "AForward", getAgent(), "Listo", "COD_ARig_AForw");
                    block();
                    
            }
            
            
               
                

                
            

        }

        @Override
        public boolean done() {
            return done;
        }
        
    }

}
