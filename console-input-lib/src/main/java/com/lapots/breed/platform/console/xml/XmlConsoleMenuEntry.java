package com.lapots.breed.platform.console.xml;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConsoleMenuEntry", propOrder = {
    "content"
})
public class XmlConsoleMenuEntry {

    @XmlElementRef(name = "console-menu-entry", namespace = "http://ui.config.ns", type = JAXBElement.class, required = false)
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "index")
    protected BigInteger index;
    @XmlAttribute(name = "text", required = true)
    protected String text;
    @XmlAttribute(name = "impl", required = true)
    protected String implementationClass;

    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    public BigInteger getIndex() {
        return index;
    }

    public void setIndex(BigInteger value) {
        this.index = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    public String getImplementationClass() {
        return implementationClass;
    }

    public void setImplementationClass(String implementationClass) {
        this.implementationClass = implementationClass;
    }
}
