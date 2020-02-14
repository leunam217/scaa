package importExport;

import models.Component;
import models.ComponentDTO;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Converter {

    public List<Component> importFromJson(Reader reader){
        try{
            Jsonb jsonb = JsonbBuilder.create();
            List<ComponentDTO> l =jsonb.fromJson(reader,new ArrayList<ComponentDTO>(){}.getClass().getGenericSuperclass());
            return null;
        }catch (Exception e){
            return Collections.EMPTY_LIST;
        }
    }
}
