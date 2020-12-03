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
 * @author Javier Erazo
 */
public class ALeft extends Agent {

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
        Obstaculo obstaculo;

        public void moverIzquierda() {
            try {
                Thread.sleep(200);
                juego.desplazarX(-5);
            } catch (InterruptedException ex) {
                Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void action() {
            switch (indice) {
                case 0:
                    ACLMessage acl = blockingReceive();

                    try {
                        obstaculo = (Obstaculo) acl.getContentObject();
                    } catch (UnreadableException ex) {
                        Logger.getLogger(ARight.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    indice = 1;
                    break;
                case 1:
                    accum += 5;
                    sigSalida = obstaculo.getLargo() - posXInicial + 20;
                    if (sigSalida > accum) {
                        moverIzquierda();
                    } else {
                        juego.avanzarGallina(-6);
                        indice = 2;
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
