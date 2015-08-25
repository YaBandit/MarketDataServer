package com.evolve.config;

/**
 * Created by dylan on 8/24/2015.
 */
public interface ConfigFileInterface {

    public String getName();

    public DataInterface getData(String configLob);

    public void parseFile();

}
