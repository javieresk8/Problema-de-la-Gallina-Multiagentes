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
import javax.swing.JPanel;

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
        public void decidirDireccion(JPanel obstaculo){
            int posObstX = obstaculo.getX();
            if (posObstX == 0)
                System.out.println("derecha");
            else 
                System.out.println("izquierda");
        
        }
        
        

        @Override
        public void action() {
            
        int posObs1Y = juego.getObs1().getPosY();
        int posObs2Y = juego.getObs2().getPosY();
        int posGallinaY = juego.getPosY();
        int distancia =  posGallinaY - posObs1Y;
        int distancia2 =  posGallinaY- posObs2Y;
        Obstaculo obstaculoEncontrado;
        if (distancia <= 30 && distancia >=25){
           obstaculoEncontrado = juego.getObs1();
           System.out.println("Esta cerca el objeto 1!!! =========================" + distancia);
           EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "AForward", getAgent(), obstaculoEncontrado, "COD_Sens_Forw");
           ACLMessage acl = blockingReceive();
        } else if (distancia2 <= 30 && distancia2 >= 25){
            obstaculoEncontrado = juego.getObs2();
            System.out.println("Esta cerca el objeto 2!!! =========================" + distancia2);
            EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "AForward", getAgent(), obstaculoEncontrado, "COD_Sens_Forw");
            ACLMessage acl = blockingReceive();
           
        }
        
            
        }
            
            
        
        
    }
    
    
    
}
