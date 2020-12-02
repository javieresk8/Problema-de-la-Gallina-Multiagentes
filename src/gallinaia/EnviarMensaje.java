
package gallinaia;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnviarMensaje {
    
    public static void enviarMensajeString(int tipoMensaje, String receptor, Agent agenteEmisor,
        String contenido, String conversationID){
        ACLMessage acl = new ACLMessage();
        AID id = new AID();
        id.setLocalName(receptor);
        acl.addReceiver(id);
        acl.setSender(agenteEmisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setContent(contenido);
        acl.setConversationId(conversationID);
        agenteEmisor.send(acl);
                
        
    }
    public static void enviarMensajeObject(int tipoMsj, String receptor, Agent agenteEmisor,
            Serializable contenido, String conversationID){
        ACLMessage acl = new ACLMessage(tipoMsj);
        AID id = new AID(); //JADE Agent Identifier
        id.setLocalName(receptor);
        acl.addReceiver(id);
        acl.setSender(agenteEmisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        
        try {
            acl.setContentObject(contenido);
        } catch (IOException e) {
            Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, e);
            
        }
        /*Identificamos y mandamos*/
        acl.setConversationId(conversationID);
        agenteEmisor.send(acl);
        
        
        
    }
    
}
