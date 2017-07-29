package com.lapots.breed.platform.json.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlJsonConverter", propOrder = {
    "fromClass",
    "toClass"
})
public class XmlJsonConverter {

    @XmlElement(name = "from-class", required = true)
    protected String fromClass;
    @XmlElement(name = "to-class", required = true)
    protected String toClass;
    @XmlAttribute(name = "class")
    protected String clazz;

    public String getFromClass() {
        return fromClass;
    }

    public void setFromClass(String value) {
        this.fromClass = value;
    }

    public String getToClass() {
        return toClass;
    }

    public void setToClass(String value) {
        this.toClass = value;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String value) {
        this.clazz = value;
    }

}
