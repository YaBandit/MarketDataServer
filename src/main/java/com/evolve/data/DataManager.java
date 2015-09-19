package com.evolve.data;

import com.evolve.util.FileLoader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dylan on 17/09/2015.
 */
public class DataManager extends FileLoader {

    private static final DataManager INSTANCE = new DataManager();
    private static final String dataDirectory = "data";

    private static final Map<OneADayTypesEnum, DataConstruct> dataConstructs = new ConcurrentHashMap<>();

    public static DataManager getINSTANCE() {
        return INSTANCE;
    }

    private DataManager() {
        try {
            loadConfig(dataDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseFile(String loc) {
        final String fileName = getNameFromFileLoc(loc);
        final OneADayTypesEnum oneADayTypesEnum = OneADayTypesEnum.valueOf(fileName);

        switch (oneADayTypesEnum) {
            case UNIX_COMMANDS:
                DataConstruct dataConstruct = parseKeyValueData();
                break;
        }
    }

    public DataConstruct getData(OneADayTypesEnum oneADayTypesEnum) {

        switch (oneADayTypesEnum) {
            case UNIX_COMMANDS:
                break;
            case ANIMALS:
                break;
            case FAMOUS_POLITIONS:
                break;
            case SCIENCE_FACT:
                break;
        }

        return null;
    }

    public DataConstruct getData(OneADayTypesEnum oneADayTypesEnum, int index) {

        return null;
    }

    private DataConstruct parseKeyValueData() {
        DataConstruct dataConstruct = null;

        BufferedInputStream bis = new BufferedInputStream(new );
    }

}
