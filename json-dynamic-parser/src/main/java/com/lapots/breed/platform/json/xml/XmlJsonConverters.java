package com.lapots.breed.platform.json.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlJsonConverters", propOrder = {
    "converter"
})
public class XmlJsonConverters {

    @XmlElement(required = true)
    protected List<XmlJsonConverter> converter;

    public List<XmlJsonConverter> getConverter() {
        if (converter == null) {
            converter = new ArrayList<XmlJsonConverter>();
        }
        return this.converter;
    }

}
