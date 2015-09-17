package com.evolve.data;

import com.evolve.util.FileLoader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Dylan on 17/09/2015.
 */
public class DataManager extends FileLoader {

    private static final DataManager INSTANCE = new DataManager();
    private static final String dataDirectory = "data";

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

}
