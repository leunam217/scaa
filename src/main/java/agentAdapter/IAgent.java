package agentAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface IAgent {
    Object getKnowledge();
    void setKnowledge(Object o);
    void sendMessage(String s, IAgent agent);
    void sendMessageBroadcast(String s);
    void setDecision(TriConsumer<String,IAgent, Object> decision);
}
