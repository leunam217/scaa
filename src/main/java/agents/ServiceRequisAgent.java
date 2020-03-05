package agents;

import agentAdapter.IAgent;

public class ServiceRequisAgent {

    public static class ServiceRequisKnowledge{
        String name;
    }

    public static void makeAgent(IAgent agent, String name){
        ServiceRequisKnowledge s = new ServiceRequisKnowledge();
        s.name = name;
        agent.setKnowledge(s);
        agent.setDecision((m, emitter, knowledge) -> {
            switch (m){
                case "PropageDemandeRequis" :
                    agent.sendMessageBroadcast("BroadcastRequis");
                    break;
            }
        });
    }
}
