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
import javax.swing.JPanel;

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
        super.takeDown();
        System.out.println("muere AForward");
    }

    @Override
    protected void setup() {
        super.setup();
        System.out.println("forward creado...");
        addBehaviour(new Comportamiento());
    }
    
    class Comportamiento extends CyclicBehaviour{
        int indice = 0;
        ACLMessage acl = null;
        /*Devuelve true si se va a la derecha, caso contrio a la izquierda*/
        public boolean decidirDireccion(Obstaculo obstaculo){
            int posObstX = obstaculo.getPosX();
            if (posObstX == 0){
                System.out.println("derecha");
                return  true;
                
            } else {
                System.out.println("izquierda");
                return false; 
               
                    
            }
                
        
        }
        @Override
        public void action() {
            try {
                
                switch(indice){
                    case 0:
                        acl = receive();
                        System.out.println(acl);
                        if(acl ==null){
                             Thread.sleep(200);
        //                    int posGallinaY = juego.getPosY();
        //                    posGallinaY +=5;
                            juego.avanzarGallina(-5);
                            System.out.println("aumento posicion" + juego.getPosY());
                        
                            
                        } else{
                            indice = 1;
                        }
                        break;
                    case 1:
                        block();
                        String a_id = acl.getConversationId();
                        System.out.println("El id es " + a_id);
                        if (a_id.equalsIgnoreCase("CODMeta")){
                            doDelete();
                            
                        }
                        boolean decision = decidirDireccion((Obstaculo)acl.getContentObject());
                        System.out.println("la decicion tomada es " + decision);
                        if (decision){
                            EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ARight", getAgent(),acl.getContentObject(), "COD_AFor_ARig");
                            ACLMessage msg = blockingReceive();
                            EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
                            indice = 0;
                            //restart();
                        } else {
                            System.out.println("Llego a mandar el mensaje a la izquierda================");
                            EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ALeft", getAgent(),acl.getContentObject(), "COD_AFor_ALef");
                            ACLMessage msg = blockingReceive();
                            EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
                            indice = 0;
                        
                    }
                        
                        
                }
//                ACLMessage acl = receive();
//                System.out.println(acl);
//                /*recuerda que no puedes sacar atibutos del acl si es null
//                se ira hasta el infinito en null si lo haces*/
//                /*Cambialo a switch case*/
//                        
//                if (acl == null){
//                    Thread.sleep(200);
////                    int posGallinaY = juego.getPosY();
////                    posGallinaY +=5;
//                    juego.avanzarGallina(-5);
//                    System.out.println("aumento posicion" + juego.getPosY());
//                    //System.out.println(acl.toString()+ "---------------------------------");
//                 } else {
//                    //if (a_id.equalsIgnoreCase("COD_Sens_Forw")){
//                    block();
//                    String a_id = acl.getConversationId();
//                    System.out.println("El id es " + a_id);
//                    boolean decision = decidirDireccion((Obstaculo)acl.getContentObject());
//                    System.out.println("la decicion tomada es " + decision);
//                    if (decision){
//                        EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ARight", getAgent(),acl.getContentObject(), "COD_AFor_ARig");
//                        ACLMessage msg = blockingReceive();
//                        EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
//                        //restart();
//                    } else {
//                        System.out.println("Llego a mandar el mensaje a la izquierda================");
//                        EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ALeft", getAgent(),acl.getContentObject(), "COD_AFor_ALef");
//                        ACLMessage msg = blockingReceive();
//                        EnviarMensaje.enviarMensajeObject(ACLMessage.INFORM, "ASensor", getAgent(), "Listo", "COD_AFor_ASen");
//                        
//                    }
//                }
                    //if (a_id.equalsIgnoreCase("COD_Sens_Forw")){
//                    block();
//                    decidirDireccion((Obstaculo)acl.getContentObject());
                    
                
                        
                    
                
            } catch (Exception e) {
            }
            
            
        }
        
    }
}
