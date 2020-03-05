package coordinator;
import importExport.Converter;
import models.Component;
import HMI.HMIUser;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Coordinator {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(4);
        Jsonb jsonb = JsonbBuilder.create();
        FileReader reader = new FileReader("src/main/resources/component.json");
        Converter converter = new Converter();
        List<Component> componentList = converter.importFromJson(reader);
      //  Optional<String> result = new Converter().exportToJsonString(componentList);

        //    System.out.println(result.orElse(""));
        HMIUser HMIUser = new HMIUser();
        Optional<Component> optionalComponent = HMIUser.getFirstComponent(componentList);
        if (!optionalComponent.isPresent())
            System.exit(1);
        System.out.println("Tu as choisi ce composant : " + Converter.exportToJsonString(Collections.singletonList(optionalComponent.get())).get());
    }
}

