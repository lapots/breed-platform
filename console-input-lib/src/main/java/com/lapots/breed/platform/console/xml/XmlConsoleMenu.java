package com.lapots.breed.platform.console.xml;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="console-menu")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public @Data class XmlConsoleMenu {
    @XmlAttribute(name="quit-command")
    private String quitCommand;
    @XmlElement(name="console-menu-entry")
    private List<XmlConsoleMenuEntry> entries;
}
