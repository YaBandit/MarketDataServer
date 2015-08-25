package com.evolve.config;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dylan on 8/24/2015.
 */
public class XmlConfigFile extends ConfigFile {

    private static final String ROOT_ELEMENT = "Data";

    public XmlConfigFile(String fileName, String fileLoc) {
        super(fileName, fileLoc);
    }

    @Override
    public DataInterface getData(String configLob) {
        return null;
    }

    @Override
    public void parseFile() {

        final Document doc;

        try {
            final File xmlFile = new File(fileLoc);
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dbBuilder;
            dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Unable to parse xml file due to: \n" + e);
            return;
        }

        final NodeList nodeList = doc.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            final Node node = nodeList.item(i);
            final String nodeName = node.getNodeName();
            XmlAttributeType xmlAttributeType = XmlAttributeType.valueOf(nodeName);

            if (xmlAttributeType ==  XmlAttributeType.DATA) {
                recurseDocument(node);
            }

            int p = 0;
        }

    }

    private void recurseDocument(Node node) {

        final NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++){
            final Node childNode = nodeList.item(i);
            final String nodeName = node.getNodeName();
            XmlAttributeType xmlAttributeType = XmlAttributeType.valueOf(nodeName);

            switch (xmlAttributeType) {
                case VARIABLE:
                    parseVariableNode(childNode);
                    break;
                case ENTRY:
                    parseEntryNode(childNode);
                    break;
            }
        }
    }

    private void parseVariableNode(Node node) {
        final String name = node.getAttributes().getNamedItem("name").getNodeValue();
        DataNode dataNode = new DataNode(false, name);
        node.get
    }

    private void parseEntryNode(Node node) {

    }

    private class DataNode {

        private String name;
        private boolean hasChild;

        private List<DataNode> childNodeList = new LinkedList<>();

        private DataInterface data = null;

        private DataNode(boolean hasChild, String name) {
            this.hasChild = hasChild;
            this.name = name;
        }

        private void addData(DataInterface data) {
            this.data = data;
        }

        private void addChildNode(DataNode dataNode) {
            childNodeList.add(dataNode);
        }
    }
}
