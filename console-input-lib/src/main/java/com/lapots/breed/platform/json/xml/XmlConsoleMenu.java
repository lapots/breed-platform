package com.lapots.breed.platform.json.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XmlConsoleMenu", propOrder = {
    "consoleMenuEntry"
})
public class XmlConsoleMenu {

    @XmlElement(name = "console-menu-entry", required = true)
    protected List<XmlConsoleMenuEntry> consoleMenuEntry;
    @XmlAttribute(name = "quit-command")
    protected String quitCommand;

    public List<XmlConsoleMenuEntry> getConsoleMenuEntry() {
        if (consoleMenuEntry == null) {
            consoleMenuEntry = new ArrayList<XmlConsoleMenuEntry>();
        }
        return this.consoleMenuEntry;
    }

    public String getQuitCommand() {
        return quitCommand;
    }

    public void setQuitCommand(String value) {
        this.quitCommand = value;
    }

}
