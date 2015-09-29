package com.evolve.data;

import com.evolve.util.FileLoader;
import javafx.util.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dylan on 17/09/2015.
 */
public class DataManager extends FileLoader {

    private static final DataManager INSTANCE = new DataManager();
    private static final String DATA_DIRECTORY = "data";
    private static final String DELIMITER = ";";

    private static Logger logger = LogManager.getLogger(DataManager.class);

    private final Map<OneADayTypesEnum, DataConstruct> dataConstructs = new ConcurrentHashMap<>();

    public static DataManager getINSTANCE() {
        return INSTANCE;
    }

    private DataManager() {
        try {
            loadConfig(DATA_DIRECTORY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseFile(String loc) throws IOException {
        final String fileName = getNameFromFileLoc(loc);
        final OneADayTypesEnum oneADayTypesEnum = OneADayTypesEnum.valueOf(fileName.toUpperCase());

        switch (oneADayTypesEnum) {
            case UNIX_COMMANDS:
                dataConstructs.put(OneADayTypesEnum.UNIX_COMMANDS, parseKeyValueData(loc));
                break;
        }
    }

    public DataConstruct getData(OneADayTypesEnum oneADayTypesEnum) {
        return dataConstructs.get(oneADayTypesEnum);
    }

    private DataConstruct parseKeyValueData(String fileLoc) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileLoc));
        String line;
        if ((line = br.readLine()) != null) {
            // Line will now equal the header line
            // Columns are: Num;Key;Value
            final String[] columns = line.split(DELIMITER);
            if (columns.length != 3) {
                logger.debug("Unable to parse data file: " + fileLoc);
                logger.debug("Requied columns = 3. Columns in file: " + columns.length);
                return null;
            }
            DataConstruct dataConstruct = new KeyValueStore(columns);
            while ((line = br.readLine()) != null) {
                final String[] parts = line.split(DELIMITER, 3);
                if (parts.length != 3) {
                    logger.debug("Incorrectly formatted line in data file: " + fileLoc + ". On line: " + line);
                    continue;
                }

                final Pair<String, String> data = new Pair<>(parts[1], parts[2]);
                final int entryNum;

                try {
                    entryNum = Integer.parseInt(parts[0]);
                } catch (NumberFormatException e) {
                    logger.debug("Unable to parse data entry numnber in data file: " + fileLoc + ". On line: " + line);
                    logger.debug(e);
                    continue;
                }
                dataConstruct.addData(entryNum, data);
            }
            return dataConstruct;
        }
        return null;
    }

}
