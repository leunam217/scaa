package Orchestrator;
import importExport.Converter;
import models.Component;
import userHMI.Ihm;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Orchestrator {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(4);
        Jsonb jsonb = JsonbBuilder.create();
        FileReader reader = new FileReader("/home/manu/Documentos/m2/scaa/src/main/resources/component.json");
        Converter converter = new Converter();
        List<Component> componentList = converter.importFromJson(reader);
      //  Optional<String> result = new Converter().exportToJsonString(componentList);

        //    System.out.println(result.orElse(""));
        Ihm ihm = new Ihm();
        Optional<Component> optionalComponent = ihm.getFirstComponent(componentList);
        if (!optionalComponent.isPresent())
            System.exit(1);
        System.out.println("T'a choisi ce composant : " + Converter.exportToJsonString(Collections.singletonList(optionalComponent.get())).get());
    }
}

