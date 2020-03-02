package userHMI.console;

import importExport.Converter;
import models.Component;
import models.Connector;

import java.util.List;
import java.util.Optional;

public class Show {
    public static void showComponentList(List<Component> components){
        Optional<String> formatedtListOpt = Converter.exportToJsonString(components);
        System.out.println(formatedtListOpt.orElse("Error in display"));
    }

    public static void askStartComponent(){
       System.out.println("With what component do  you want to start with? Enter the name");
    }

    public static void askForExpertChoice(List<Component> choiceOwner, Connector with){
        System.out.println("Several choices found for conecting "+with.service+ "of "+ with.owner.name);
        System.out.println(Converter.exportToJsonString(choiceOwner).orElse("Error Printing the options"));
        System.out.println("What component do you want?");
    }

    public static void showResults(List<Component> result) {
        System.out.println("The build succed here is the result :");
        System.out.println(Converter.exportToJsonString(result).orElse("Error Printing the result"));
    }

    public static void askFileLocation() {
        System.out.println("Please enter the location of the file containing the environment (list of available components");
    }

}

