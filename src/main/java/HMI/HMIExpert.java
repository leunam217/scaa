package HMI;

import models.Component;
import models.Connector;
import HMI.console.Get;
import HMI.console.Show;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HMIExpert {
    public HMIExpert() {
    }

    public Optional<Connector> getExpertChoice(List<Connector> choices, Connector with) {
        if (choices.isEmpty())
            return Optional.empty();
        List<Component> choiceOwners = choices.stream().map(c -> c.owner).collect(Collectors.toList());
        Show.askForExpertChoice(choiceOwners, with);
        Optional<Component> result = Optional.empty();
        do {
            Show.askStartComponent();
            result = Get.getComponent(choiceOwners);
        } while (!result.isPresent());
        final Optional<Component> finalResult = result;
        List<Connector> chosedConnectors = choices.stream()
                .filter(c -> c.owner.name.equals(finalResult.get().name))
                .collect(Collectors.toList());

        return chosedConnectors.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(chosedConnectors.get(0));
    }
}