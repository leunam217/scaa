package AgentAdapter;

import MockINFRA.Infrastructure;
import models.Component;

import java.util.List;

public class AgentService {

    private AgentLifeCycle agentLifeCycle;
    private ApplicationGenerator applicationGenerator;
    private Infrastructure infra;

    public AgentService(AgentLifeCycle agentLifeCycle, ApplicationGenerator applicationGenerator, Infrastructure infra) {
        this.agentLifeCycle = agentLifeCycle;
        this.applicationGenerator = applicationGenerator;
        this.infra = infra;
    }

    public Infrastructure createEnvironement(List<Component> listComponent) {
        return agentLifeCycle.createAgent(listComponent);
    }

    public List<Component> generateApplication(Component selectedComponent) {
        return applicationGenerator.generate(infra, selectedComponent);
    }
}
