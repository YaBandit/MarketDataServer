package com.evolve.data;

import javafx.util.Pair;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dylan on 19/09/2015.
 */
public class KeyValueStore implements DataConstruct <Pair<String, String>> {

    private final Map<Integer, Pair<String, String>> dataMap = new ConcurrentHashMap<>();
    private final String[] columnHeadings;

    public KeyValueStore(String[] columnHeadings) {
        this.columnHeadings = columnHeadings;
    }

    @Override
    public Pair<String, String> getData() {
        final int randomSelection = random.nextInt(dataMap.size());
        return dataMap.get(randomSelection);
    }

    @Override
    public Pair<String, String> getData(int i) {
        return dataMap.get(i);
    }

    @Override
    public void addData(int entryNum, Pair<String, String> data) {
        dataMap.putIfAbsent(entryNum, data);
    }

    @Override
    public String[] getColumnHeadings() {
        return new String[0];
    }
}
