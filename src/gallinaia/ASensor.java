package gallinaia;

import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier Erazo
 */
public class ASensor extends Agent {

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("ASensor muerto");
    }

    @Override
    protected void setup() {
        super.setup();
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {

            int posObs1Y = juego.getObs1().getPosY();
            int posObs2Y = juego.getObs2().getPosY();
            int posGallinaY = juego.getPosY();
            int distancia = posGallinaY - posObs1Y;
            int distancia2 = posGallinaY - posObs2Y;
            Obstaculo obstaculoEncontrado;
            if (distancia <= 30 && distancia >= 25) {
                obstaculoEncontrado = juego.getObs1();
                System.out.println("Esta cerca el objeto 1: " + distancia);
                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "AForward", getAgent(), obstaculoEncontrado, "COD_Sens_Forw");
                ACLMessage acl = blockingReceive();
            } else if (distancia2 <= 30 && distancia2 >= 25) {
                obstaculoEncontrado = juego.getObs2();
                System.out.println("Esta cerca el objeto 2: " + distancia2);
                EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "AForward", getAgent(), obstaculoEncontrado, "COD_Sens_Forw");
                ACLMessage acl = blockingReceive();
            }

            if (juego.getPosY() <= juego.getPosYMeta()) {
                JOptionPane.showMessageDialog(null, "FELICITACIONES la gallina cruzó la calle");
                EnviarMensaje.enviarMensajeString(ACLMessage.INFORM, "AForward", getAgent(), "llegamos", "CODMeta");

                doDelete();

            }

        }

    }

}
