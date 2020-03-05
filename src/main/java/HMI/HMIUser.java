package HMI;

import models.Component;
import HMI.console.Get;
import HMI.console.Show;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class HMIUser {

    public Optional<Component> getFirstComponent(List<Component> components){
        Show.showComponentList(components);
        Optional<Component> result = Optional.empty();
        do {
            Show.askStartComponent();
             result = Get.getComponent(components);
        }while (! result.isPresent());
        return result;
    }

    public void showResults(List<Component> result){
        Show.showResults(result);
    }

    public List<Component> importEnvironment() throws FileNotFoundException {
        Show.askFileLocation();
        return Get.getEnvironment();
    }
}
