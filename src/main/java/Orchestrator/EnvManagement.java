package Orchestrator;

import AgentAdapter.AgentService;
import MockINFRA.Infrastructure;
import models.Component;
import Services.DataService;
import Services.DescisonMaker;
import Services.EnvironmentService;

import java.util.List;

public class EnvManagement {
    private DescisonMaker descisonMaker;
    private EnvironmentService environmentService;
    private DataService dataService;
    private AgentService agentService;

    public Infrastructure makeEnvironement(List<Component> listComponent){
        return agentService.createEnvironement(listComponent);
    }

    public List<Component> makeApplication(Component choosen){
        return agentService.generateApplication(choosen);
    }


}
