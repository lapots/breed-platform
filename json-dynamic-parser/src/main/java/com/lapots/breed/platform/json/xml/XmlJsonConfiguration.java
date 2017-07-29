package com.lapots.breed.platform.json.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlJsonConfiguration", propOrder = {
    "data"
})
public class XmlJsonConfiguration {

    @XmlElement(required = true)
    protected List<XmlConfigurationData> data;

    public List<XmlConfigurationData> getData() {
        if (data == null) {
            data = new ArrayList<XmlConfigurationData>();
        }
        return this.data;
    }

}
