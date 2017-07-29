package com.lapots.breed.platform.json.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConfigurationFilePath", propOrder = {
    "value"
})
public class XmlConfigurationFilePath {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "resources-path")
    protected String resourcesPath;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(String value) {
        this.resourcesPath = value;
    }

}
