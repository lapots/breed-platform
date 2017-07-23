package com.lapots.breed.platform.console.xml;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;

    @XmlRootElement(name="console-menu-entry")
    @XmlAccessorType(XmlAccessType.FIELD)
    @ToString
    public @Data class XmlConsoleMenuEntry {
        @XmlAttribute
        private String index;
        @XmlAttribute
        private String text;
        /*
        @XmlValue // TODO: solve issue with value processing
        private String value;*/
        @XmlElement(name="console-menu-entry")
        private List<XmlConsoleMenuEntry> entries;
    }
