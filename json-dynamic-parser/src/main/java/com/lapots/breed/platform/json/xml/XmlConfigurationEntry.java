package com.lapots.breed.platform.json.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConfigurationEntry", propOrder = {
    "label",
    "domainClass",
    "repositoryClass"
})
public class XmlConfigurationEntry {

    @XmlElement(required = true)
    protected String label;
    @XmlElement(name = "domain-class", required = true)
    protected String domainClass;
    @XmlElement(name = "repository-class", required = true)
    protected String repositoryClass;

    public String getLabel() {
        return label;
    }

    public void setLabel(String value) {
        this.label = value;
    }

    public String getDomainClass() {
        return domainClass;
    }

    public void setDomainClass(String value) {
        this.domainClass = value;
    }

    public String getRepositoryClass() {
        return repositoryClass;
    }

    public void setRepositoryClass(String value) {
        this.repositoryClass = value;
    }

}
