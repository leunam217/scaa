package models;

public class ConnectorDTO {

    private String service;
    private String linkedTo;

    //<editor-fold desc="Get set">
    public ConnectorDTO(){}

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLinkedTo() {
        return linkedTo;
    }

    public void setLinkedTo(String linkedTo) {
        this.linkedTo = linkedTo;
    }
    //</editor-fold>

}
