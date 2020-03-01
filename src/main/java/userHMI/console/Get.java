package userHMI.console;

import importExport.Converter;
import models.Component;
import models.Connector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Get {

    private static Scanner scanner = new Scanner(System.in);

    public static Optional<Component> getComponent(List<Component> components) {
        String componentName = scanner.nextLine();
        List<Component> result = components.stream().filter(component -> component.name.equals(componentName)).collect(Collectors.toList());
        if (result.size() != 0){
            return Optional.ofNullable(result.get(0));
        }
        return Optional.empty();
    }

    public static List<Component> getEnvironment() throws FileNotFoundException {
        String fileName = scanner.nextLine();
        FileReader reader = new FileReader(fileName);
        return Converter.importFromJson(reader);
    }



}
