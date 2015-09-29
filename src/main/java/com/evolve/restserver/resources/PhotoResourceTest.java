package com.evolve.restserver.resources;

import org.apache.commons.codec.binary.Base64;

import org.json.simple.JSONObject;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by dylan on 28/09/2015.
 */
public class PhotoResourceTest extends ServerResource {

    @Get
    public JSONObject getPhoto() throws ResourceException {

        try {
            /*
            File imgPath = new File("images.Battleship_Gothic_cover.jpg");
            BufferedImage bufferedImage = ImageIO.read(imgPath);

            WritableRaster raster = bufferedImage.getRaster();
            DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
            */

            File fi = new File("images/Battleship_Gothic_cover.jpg");
            byte[] fileContent = Files.readAllBytes(fi.toPath());

            String imageDataString = Base64.encodeBase64URLSafeString(fileContent);


            JSONObject jsonObject = new JSONObject();
            jsonObject.put("photo", imageDataString);

            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
