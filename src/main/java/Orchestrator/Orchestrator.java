package Orchestrator;
import importExport.Converter;
import models.Component;
import models.ComponentDTO;
import userHMI.ComponentSelector;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Orchestrator {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(4);
        Jsonb jsonb = JsonbBuilder.create();
        FileReader reader = new FileReader("src/main/resources/component.json");
        Converter converter = new Converter();
        List<Component> componentList = converter.importFromJson(reader);
      //  Optional<String> result = new Converter().exportToJsonString(componentList);

        //    System.out.println(result.orElse(""));
        ComponentSelector componentSelector = new ComponentSelector();
        Optional<Component> optionalComponent = componentSelector.getFirstComponent(componentList);
        if (!optionalComponent.isPresent())
            System.exit(1);
        System.out.println("T'a choisi ce composant : " + Converter.exportToJsonString(Collections.singletonList(optionalComponent.get())).get());
    }
}

