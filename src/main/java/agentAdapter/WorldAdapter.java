package agentAdapter;

import MASInfrastructure.Agent.InfraAgent;
import MASInfrastructure.Infrastructure;
import MASInfrastructure.State.LifeCycle;
import MASInfrastructure.exemple.CommunicationParMessage;

public class WorldAdapter implements IWorld {

    private final Infrastructure i;
    private final CommunicationParMessage maCom;

    public WorldAdapter(){
        // un scheduler et un annuaire
        i = new Infrastructure();
        maCom = new CommunicationParMessage(i);

    }
    @Override
    public void addAgent(IAgent iAgent) {
        AgentAdapter agent = (AgentAdapter) iAgent;
        InfraAgent infraAgent = i.createInfrastructureAgent(new LifeCycle(agent.etatDecision), maCom);
        agent.etatDecision.infraAgent = infraAgent;
        agent.etatDecision.communication = maCom;
    }

    @Override
    public void start() {
        i.startScheduling();
    }

    public static void main(String[] args) {
        IWorld world = new WorldAdapter();
        IAgent a1 = new AgentAdapter();
        IAgent a2 = new AgentAdapter();
        world.addAgent(a1);
        world.addAgent(a2);

        a1.setDecision((s, emitter, knowledge) -> {
            a1.sendMessage("lol",a2);
        });
        a2.setDecision((s, emitter, knowledge) -> {System.out.println(s);System.exit(0);});
        a1.sendMessage("prelol",a1);

        world.start();
    }
}
