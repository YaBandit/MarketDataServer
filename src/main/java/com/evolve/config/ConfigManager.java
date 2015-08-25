package com.evolve.config;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private static final ConfigManager INSTANCE = new ConfigManager();

    public static ConfigManager getInstance() { return INSTANCE; }

    private ConfigManager() {
        // Required to ensure singleton status
    }

    private final List<ConfigFileInterface> configList = new ArrayList<>();

    public void addFile(ConfigFileInterface configFile) {
        configList.add(configFile);
    }

    private static final String SPLITTER = ".";

    public DataInterface getData(String desriedConfig) {

        final String[] configParts = desriedConfig.split(SPLITTER);

        final DataInterface[] data = new DataInterface[1];

        configList.stream()
                .filter(file -> file.getName().contains(configParts[1]))
                .forEach((file) -> {
                    data[0] = file.getData(desriedConfig);
        });

        return data[0];
    }

}
