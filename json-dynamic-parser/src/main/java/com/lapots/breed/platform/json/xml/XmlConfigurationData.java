package com.lapots.breed.platform.json.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConfigurationData", propOrder = {
    "filePath",
    "entries"
})
public class XmlConfigurationData {

    @XmlElement(name = "file-path", required = true)
    protected XmlConfigurationFilePath filePath;
    @XmlElement(required = true)
    protected XmlConfigurationEntries entries;
    @XmlAttribute(name = "type")
    protected String type;

    public XmlConfigurationFilePath getFilePath() {
        return filePath;
    }

    public void setFilePath(XmlConfigurationFilePath value) {
        this.filePath = value;
    }

    public XmlConfigurationEntries getEntries() {
        return entries;
    }

    public void setEntries(XmlConfigurationEntries value) {
        this.entries = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

}
