package models;

import java.util.Optional;

public class Connector {

    public String service = "" ;
    public Component owner;
    public Optional<Connector>linkedTo = Optional.empty();

}
