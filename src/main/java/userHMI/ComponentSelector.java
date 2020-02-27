package userHMI;

import models.Component;
import models.Connector;
import userHMI.console.Get;
import userHMI.console.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ComponentSelector {

    public Optional<Connector> getChoice(List<Connector> l,  Connector with){
        System.out.println("Several choices found for conecting ");
        if (l == null || l.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(l.get(0));
    }

    //code is obvious
    public Optional<Component> getFirstComponent(List<Component> components){
        Show.showComponentList(components);
        Optional<Component> result = Optional.empty();
        do {
            Show.askStartComponent();
             result = Get.getComponent(components);
        }while (! result.isPresent());
        return result;
    }


}
