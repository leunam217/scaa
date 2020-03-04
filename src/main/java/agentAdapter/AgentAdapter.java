package agentAdapter;

import MASInfrastructure.Agent.InfraAgent;
import MASInfrastructure.Agent.InfraAgentReference;
import MASInfrastructure.Communication.ICommunication;
import MASInfrastructure.Communication.IMessage;
import MASInfrastructure.State.IState;
import MASInfrastructure.State.LifeCycle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class AgentAdapter implements IAgent {

    EtatDecision etatDecision = new EtatDecision();

    @Override
    public void setKnowledge(Object o) {
        etatDecision.knowledge = o;
    }

    @Override
    public void sendMessage(String s, IAgent agent) {
        etatDecision.sendMessage(s, (AgentAdapter) agent,this);
    }

    @Override
    public void sendMessageBroadcast(String s) {
        etatDecision.sendMessageBroadcast(s, this);
    }

    @Override
    public void setDecision(TriConsumer<String, IAgent, Object> decision) {
        etatDecision.decision = decision;
    }

    static class Message implements IMessage {
        private IAgent iAgentEmitter;
        private InfraAgentReference emitter;
        private ArrayList<InfraAgentReference> receivers = new ArrayList();
        private String content;


        public Message(InfraAgentReference emitter, InfraAgentReference receiver, IAgent iAgentEmitter, String message) {
            this.emitter = emitter;
            this.iAgentEmitter = iAgentEmitter;
            this.receivers.add(receiver);
            this.content = message;
        }

        @Override
        public InfraAgentReference getEmitter() {
            return emitter;
        }

        @Override
        public void setEmitter(InfraAgentReference emitter) {

        }


        @Override
        public ArrayList<InfraAgentReference> getReceivers() {
            return receivers;
        }

        @Override
        public void setReceivers(ArrayList<InfraAgentReference> receivers) {

        }

        public String getContent() {
            return content;
        }

        public IAgent getiAgentEmitter() {
            return iAgentEmitter;
        }

        public void setiAgentEmitter(IAgent iAgentEmitter) {
            this.iAgentEmitter = iAgentEmitter;
        }
    }

    static class EtatDecision implements IState {

        ICommunication communication;
        IState nextState = this;
        InfraAgent infraAgent;

        Object knowledge;
        TriConsumer<String, IAgent, Object> decision =   (l,o,ll) ->{};

        public void setCommunication(ICommunication communication) {
            this.communication = communication;
        }

        public void setInfraAgent(InfraAgent infraAgent) {
            this.infraAgent = infraAgent;
        }

        public void setNextState(IState nextState) {
            this.nextState = nextState;
        }

        void sendMessage(String s,AgentAdapter to,AgentAdapter me){
            Message m1 = new Message(infraAgent.getInfraAgentReference(),
                    to.etatDecision.infraAgent.getInfraAgentReference(),
                    me,
                    s);
            communication.sendMessage(m1);
        }

        void sendMessageBroadcast(String s, AgentAdapter me){
            Message m1 = new Message(infraAgent.getInfraAgentReference(),
                    null,
                    me,
                    s);
            communication.sendMessageBroadcast(m1);
        }

        @Override
        public void execute(LifeCycle c) {
            List<Message> infraMessages = this.infraAgent.readMessages()
                    .stream()
                    .map(x -> (Message) x).collect(Collectors.toList());
            if (infraMessages.size() != 0) {
                Message m = infraMessages.get(0);
                decision.accept(m.content,m.iAgentEmitter, knowledge);
            }
            c.setCurrentState(this.nextState);
        }
    }
}
