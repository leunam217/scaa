package importExport;

import models.Component;
import models.ComponentDTO;
import models.Connector;
import models.ConnectorDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Converter {

    private static List<Component> DTOListToList(List<ComponentDTO> l) {
        return l.stream().map(componentDTO -> {
            Component c = new Component();
            c.name = componentDTO.getName();
            c.inports = getConnectors(componentDTO.getInports(), c);
            c.outports = getConnectors(componentDTO.getOutports(),c);
            return c;
        }).collect(Collectors.toList());
    }

    private static List<Connector> getConnectors(List<ConnectorDTO> list, Component c) {
        return list.stream().map(connectorDTO -> {
            Connector connector = new Connector();
            connector.service = connectorDTO.getService();
            connector.owner = c;
            return connector;
        }).collect(Collectors.toList());
    }

    public static List<Component> importFromJson(Reader reader){
        try{
            Jsonb jsonb = JsonbBuilder.create();
            List<ComponentDTO> l =jsonb.fromJson(reader,new ArrayList<ComponentDTO>(){}.getClass().getGenericSuperclass());
            return DTOListToList(l);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }


    private static List<ConnectorDTO> getConnectorsDTO (List<Connector> list, Component c){
        return list.stream().map(connector -> {
            ConnectorDTO connectorDTO = new ConnectorDTO();
            connectorDTO.setService(connector.service);
            if (!connector.linkedTo.isPresent())
                connectorDTO.setLinkedTo("None");
            else
                connectorDTO.setLinkedTo(connector.linkedTo.get().owner.name);
            return connectorDTO;
        }).collect(Collectors.toList());
    }

    private static List<ComponentDTO> listToDTOList(List<Component> l) {
        return l.stream().map(component -> {
            ComponentDTO componentDTO = new ComponentDTO();
            componentDTO.setName(component.name);
            componentDTO.setInports(getConnectorsDTO(component.inports, component));
            componentDTO.setOutports(getConnectorsDTO(component.outports, component));
            return componentDTO;
        }).collect(Collectors.toList());
    }

    public static Optional<String> exportToJsonString(List<Component> l){
        List <ComponentDTO> typedResult = listToDTOList(l);
        try {
            Jsonb jsonb = JsonbBuilder.create();
            return Optional.ofNullable(jsonb.toJson(typedResult));
        }catch (Exception e){
            return Optional.empty();
        }
    }

}
