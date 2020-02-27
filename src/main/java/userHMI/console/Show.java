package userHMI.console;

import models.Component;
import userHMI.ViewComponent;

import java.util.List;
import java.util.Optional;

public class Show {
    public static void showComponentList(List<Component> components){
        Optional<String> formatedtListOpt = ViewComponent.format(components);
        System.out.println(formatedtListOpt.orElse("Error in display"));
    }

    public static void askStartComponent(){
       System.out.println("With what component you do want to start with? Enter the name");
    }

}

