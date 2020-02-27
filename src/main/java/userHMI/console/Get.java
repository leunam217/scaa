package userHMI.console;

import models.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Get {

    public static Optional<Component> getComponent(List<Component> components) {
        Scanner scanner = new Scanner(System.in);
        String componentName = scanner.nextLine();
        List<Component> result = components.stream().filter(component -> component.name.equals(componentName)).collect(Collectors.toList());
        if (result.size() != 0){
            return Optional.ofNullable(result.get(0));
        }
        return Optional.empty();
    }


}
