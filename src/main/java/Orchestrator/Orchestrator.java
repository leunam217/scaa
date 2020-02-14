package Orchestrator;
import models.ComponentDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Orchestrator {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(4);
        Jsonb jsonb = JsonbBuilder.create();
        FileReader reader = new FileReader("/home/manu/Documentos/m2/scaa/src/main/resources/component.json");
        List<ComponentDTO> l =jsonb.fromJson(reader,new ArrayList<ComponentDTO>(){}.getClass().getGenericSuperclass());
        System.out.println(l.get(0).getName());
    }
}

