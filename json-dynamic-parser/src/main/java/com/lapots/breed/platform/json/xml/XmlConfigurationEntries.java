package com.lapots.breed.platform.json.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConfigurationEntries", propOrder = {
    "entry"
})
public class XmlConfigurationEntries {

    @XmlElement(required = true)
    protected List<XmlConfigurationEntry> entry;

    public List<XmlConfigurationEntry> getEntry() {
        if (entry == null) {
            entry = new ArrayList<XmlConfigurationEntry>();
        }
        return this.entry;
    }

}
