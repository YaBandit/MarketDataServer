package com.evolve.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by dylan on 8/20/2015.
 */
public abstract class ConfigFile implements ConfigFileInterface {

    public final Logger logger = LogManager.getLogger(ConfigFile.class);

    public final String fileName;
    public final String fileLoc;

    public ConfigFile(String fileName, String fileLoc) {
        this.fileName = fileName;
        this.fileLoc = fileLoc;
    }

    public String getName() {
        return fileName;
    }

}
