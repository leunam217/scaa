package agents;

import MASInfrastructure.Infrastructure;
import agentAdapter.IAgent;
import models.Component;

import java.util.List;

public class ServiceFournisAgent {

    public static class ServiceFournisKnowledge{
        boolean connected = false;
        List<Component> environment;
        String name;
        IAgent component;
    }

    public static void makeAgent(IAgent serviceAgent, List<Component> environment, String name, IAgent component){
        ServiceFournisKnowledge s = new ServiceFournisKnowledge();
        s.environment = environment;
        s.name = name;
        s.component = component;
        serviceAgent.setKnowledge(s);
        serviceAgent.setDecision((m, emitter, knowledge) -> {
            ServiceFournisKnowledge typedKnowledge = ((ServiceFournisKnowledge) knowledge);
            switch (m){
                case "BroadcastRequis" :
                    String requisName = ((ServiceRequisAgent.ServiceRequisKnowledge) emitter.getKnowledge()).name;
                    String myName = typedKnowledge.name;
                    if ( requisName.equals(name) )
                        if (typedKnowledge.connected)
                            serviceAgent.sendMessage("JeSuisPris",emitter);
                        else
                            serviceAgent.sendMessage("JeSuisLibre",emitter);
                    break;
                case "JeTeChoisi" :

            }
        });
    }
}
