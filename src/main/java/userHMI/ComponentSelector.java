package userHMI;

import models.Connector;

import java.util.List;
import java.util.Optional;

public class ComponentSelector {

    public Optional<Connector> getChoice(List<Connector> l){
        if (l == null || l.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(l.get(0));
    }


}
