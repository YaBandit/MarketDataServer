package com.evolve.config;

/**
 * Created by dylan on 8/24/2015.
 */
public enum XmlAttributeType {

    DATA("data"),
    VARIABLE("variable"),
    ENTRY("entry");

    XmlAttributeType(String arributeType) {
        this.attributeType = arributeType;
    }

    private final String attributeType;

    public String getAttributeType() {
        return attributeType;
    }

}
