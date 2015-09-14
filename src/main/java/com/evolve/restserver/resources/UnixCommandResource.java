package com.evolve.restserver.resources;

import org.json.simple.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * Created by dylan on 09/09/2015.
 */
public class UnixCommandResource extends ServerResource{

    @Get
    public JSONObject getUnixCommand() throws ResourceException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cd", "Change directory");
        return jsonObject;
    }
}
