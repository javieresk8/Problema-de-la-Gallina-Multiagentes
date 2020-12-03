package gallinaia;

import View.Juego;
import com.sun.istack.internal.logging.Logger;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;

/**
 *
 * @author uuse
 */
public class Contenedor {

    AgentController agentController;
    AgentContainer mainContainer;
    public static Juego juego;
    
    public void contenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        runtime.setCloseVM(true);
        System.out.println("Runtime creado");
        
        Profile profile = new ProfileImpl(null, 1099, null);
        System.err.println("Perfi creado");
        
        mainContainer = (AgentContainer) runtime.createMainContainer(profile);
        System.out.println(String.format("Contenedor creado %s", profile.toString()));
        iniciarAgentes();
    }
    
    private void iniciarAgentes(){
        try {
            mainContainer.createNewAgent("ARight", ARight.class.getName(), null).start();
            mainContainer.createNewAgent("ALeft", ALeft.class.getName(), null).start();
            mainContainer.createNewAgent("AForward", AForward.class.getName(), null).start();
            mainContainer.createNewAgent("ASensor", ASensor.class.getName(), null).start();
            
        } catch (StaleProxyException e) {
            Logger.getLogger(Contenedor.class.getName(), null).log(Level.SEVERE, null, e);
        }
        
        
    }
    public static void main(String[] args) {
       juego = new Juego();
       juego.setVisible(true);
       new Contenedor().contenedor();
    }
    
}
