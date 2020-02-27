package userHMI;

import importExport.Converter;
import models.Component;

import java.util.List;
import java.util.Optional;

public class ViewComponent {

    public static Optional<String> format(List<Component> components){
        return Converter.exportToJsonString(components);
    }
}
