package Orchestrator;
import importExport.Converter;
import models.Component;
import models.ComponentDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Orchestrator {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(4);
        Jsonb jsonb = JsonbBuilder.create();
        FileReader reader = new FileReader("/home/jonlaokan/Code/al/scaa/src/main/resources/component.json");
        Converter converter = new Converter();
        List<Component> componentList = converter.importFromJson(reader);
        Optional<String> result = new Converter().exportToJsonString(componentList);

        System.out.println(result.orElse(""));
    }
}

