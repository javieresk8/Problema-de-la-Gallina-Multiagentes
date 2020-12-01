/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gallinaia;

import static gallinaia.Contenedor.juego;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author uuse
 */
public class ASensor extends Agent{

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setup() {
        super.setup(); //To change body of generated methods, choose Tools | Templates.
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            
        int posObs1Y = juego.getPosObs1Y();
        int posObs2Y = juego.getPosObs2Y();
        int posGallinaY = juego.getPosY();
        int distancia =  posGallinaY - posObs1Y;
        int distancia2 =  posGallinaY- posObs2Y;
        
        if (distancia <= 30 && distancia >=25){
            JOptionPane.showMessageDialog(null, "Esta cerca un objeto 111!!! =========================" + distancia);
            EnviarMensaje.enviarMensajeString(ACLMessage.INFORM, "AForward", getAgent(), "Encontre Obs1`", "COD001");
        }
            // System.out.println("Esta cerca un objeto 111!!! =========================" + distancia);
             //decidirDireccion(Obs1);
        }
            
            
        
        
    }
    
    
    
}
