package com.evolve.restserver.resources;

import com.evolve.data.DataConstruct;
import com.evolve.data.DataManager;
import com.evolve.data.OneADayTypesEnum;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * Created by dylan on 09/09/2015.
 */
public class UnixCommandResource extends ServerResource{

    private final DataConstruct<Pair<String, String>> dataConstruct = DataManager.getINSTANCE().getData(OneADayTypesEnum.UNIX_COMMANDS);

    @Get
    public JSONObject getUnixCommand() throws ResourceException {
        JSONObject jsonObject = new JSONObject();

        final Pair<String, String> randomData = dataConstruct.getData();

        jsonObject.put(randomData.getKey(), randomData.getValue());

        return jsonObject;
    }
}
