package models;

import java.util.ArrayList;
import java.util.List;

public class ComponentDTO {
    private String name;
    private List<ConnectorDTO> inports = new ArrayList<>();
    private List<ConnectorDTO> outports = new ArrayList<>();

    //<editor-fold desc="Get set">
    public ComponentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ConnectorDTO> getInports() {
        return inports;
    }

    public void setInports(List<ConnectorDTO> inports) {
        this.inports = inports;
    }

    public List<ConnectorDTO> getOutports() {
        return outports;
    }

    public void setOutports(List<ConnectorDTO> outports) {
        this.outports = outports;
    }
    //</editor-fold>
}
