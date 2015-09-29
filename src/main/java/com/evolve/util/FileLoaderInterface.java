package com.evolve.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Dylan on 17/09/2015.
 */
public interface FileLoaderInterface {

    public void parseFile(String fileLoc) throws IOException, SAXException, ParserConfigurationException;


}
