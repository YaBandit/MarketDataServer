package com.evolve.util;

import com.evolve.config.ConfigFileInterface;
import com.evolve.config.XmlConfigFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dylan on 17/09/2015.
 */
public abstract class FileLoader implements FileLoaderInterface {

    public void loadConfig(String directory) throws IOException {
        Files.walk(Paths.get(directory)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                try {
                    parseFile(filePath.toString());
                } catch (IOException | SAXException | ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public String getNameFromFileLoc(String fileLoc) {
        final String[] parts = fileLoc.split("\\\\");
        final String end = parts[parts.length -1];
        final String[] nameParts = end.split("\\.");
        return nameParts[0];
    }

}
