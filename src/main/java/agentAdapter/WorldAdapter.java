package agentAdapter;

import MASInfrastructure.Agent.InfraAgent;
import MASInfrastructure.Agent.InfraAgentReference;
import MASInfrastructure.Communication.ICommunication;
import MASInfrastructure.Communication.IMessage;
import MASInfrastructure.Infrastructure;
import MASInfrastructure.State.LifeCycle;

import java.util.ArrayList;
import java.util.Optional;

public class WorldAdapter implements IWorld {

    private final Infrastructure i;
    private final CommunicationParMessage maCom;

    public WorldAdapter(){
        // un scheduler et un annuaire
        i = new Infrastructure();
        maCom = new CommunicationParMessage(i);

    }

    static class CommunicationParMessage implements ICommunication {
        private Infrastructure i;

        public void sendMessageBroadcast(IMessage message) {
            i.sendMessageBroadcast(message);
        }

        public CommunicationParMessage(Infrastructure i) {
            this.i = i;
        }

        public void sendMessage(IMessage message) {
            this.i.sendMessage(message);
        }

        public Optional<IMessage> receiveMessage(InfraAgentReference reciever) {
            return Optional.empty();
        }

        public ArrayList<IMessage> receiveMessages(InfraAgentReference reciever) {
            return this.i.receiveMessages(reciever);
        }

        public Infrastructure getI() {
            return this.i;
        }
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
            a1.sendMessageBroadcast("lol");
        });
        a2.setDecision((s, emitter, knowledge) -> {System.out.println(s);System.exit(0);});
        a1.sendMessage("prelol",a1);

        world.start();
    }
}
