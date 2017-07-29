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
    protected Boolean resourcesPath;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean isResourcesPath() {
        return resourcesPath;
    }

    public void setResourcesPath(Boolean value) {
        this.resourcesPath = value;
    }

}
