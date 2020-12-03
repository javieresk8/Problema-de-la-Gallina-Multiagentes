package gallinaia;

import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Javier Erazo
 */
public class AForward extends Agent {

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("muere AForward");
    }

    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        int indice = 0;
        ACLMessage acl = null;

        /*Devuelve true si se va a la derecha, caso contrario a la izquierda*/
        public boolean decidirDireccion(Obstaculo obstaculo) {
            int posObstX = obstaculo.getPosX();
            if (posObstX == 0) {
                System.out.println("derecha");
                return true;

            } else {
                System.out.println("izquierda");
                return false;
            }

        }

        @Override
        public void action() {
            try {

                switch (indice) {
                    case 0:
                        acl = receive();
                        if (acl == null) {
                            Thread.sleep(200);
                            juego.avanzarGallina(-5);
                        } else {
                            indice = 1;
                        }
                        break;
                    case 1:
                        block();
                        String a_id = acl.getConversationId();
                        if (a_id.equalsIgnoreCase("CODMeta")) {
                            doDelete();
                        } else {
                            boolean decision = decidirDireccion((Obstaculo) acl.getContentObject());
                            if (decision) {
                                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ARight", getAgent(), acl.getContentObject(), "COD_AFor_ARig");
                                ACLMessage msg = blockingReceive();
                                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
                                indice = 0;
                            } else {
                                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ALeft", getAgent(), acl.getContentObject(), "COD_AFor_ALef");
                                ACLMessage msg = blockingReceive();
                                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
                                indice = 0;

                            }

                        }
                }

            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e);
            }

        }

    }
}
