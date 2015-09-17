package com.evolve.data;

/**
 * Created by Dylan on 17/09/2015.
 */
public class DataManager {

    private static final DataManager INSTANCE = new DataManager();

    public static DataManager getINSTANCE() {
        return INSTANCE;
    }

    private DataManager() {
        loadData();
    }

    private void loadData() {

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
