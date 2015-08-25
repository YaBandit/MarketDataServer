package com.evolve.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dylan on 8/20/2015.
 */
public class ConfigLoader {

    private static final ConfigManager configManager = ConfigManager.getInstance();
    private static Logger logger = LogManager.getLogger(ConfigLoader.class);

    private static final String configDirectory = "src/main/Config";

    public static void loadConfig() throws IOException {
        Files.walk(Paths.get(configDirectory)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                try {
                    parseFile(filePath.toString());
                } catch (IOException | SAXException | ParserConfigurationException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void parseFile(String fileLoc) throws IOException, SAXException, ParserConfigurationException {

        ConfigFileInterface configFile = null;

        if (fileLoc.contains(".xml")) {
            configFile = new XmlConfigFile(getNameFromFileLoc(fileLoc), fileLoc);
        } else {
            logger.error("Unable to parse config file: " + fileLoc + " due to incorrect file type.");
        }

        if (configFile == null) {
            logger.error("Config file not being added to config manager due to being null for: " + fileLoc);
            return;
        }

        configFile.parseFile();
        configManager.addFile(configFile);
        logger.debug("Adding config file to config manager: " + fileLoc);
    }

    public static String getNameFromFileLoc(String fileLoc) {
        final String[] parts = fileLoc.split("\\\\");
        final String end = parts[parts.length -1];
        final String[] nameParts = end.split("\\.");
        return nameParts[0];
    }

}
