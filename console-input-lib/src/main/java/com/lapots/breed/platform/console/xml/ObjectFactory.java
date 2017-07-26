package com.lapots.breed.platform.console.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsoleMenuEntry_QNAME = new QName("http://ui.config.ns", "console-menu-entry");
    private final static QName _ConsoleMenu_QNAME = new QName("http://ui.config.ns", "console-menu");

    public ObjectFactory() {
    }

    public XmlConsoleMenu createXmlConsoleMenu() {
        return new XmlConsoleMenu();
    }

    public XmlConsoleMenuEntry createXmlConsoleMenuEntry() {
        return new XmlConsoleMenuEntry();
    }

    @XmlElementDecl(namespace = "http://ui.config.ns", name = "console-menu-entry")
    public JAXBElement<XmlConsoleMenuEntry> createConsoleMenuEntry(XmlConsoleMenuEntry value) {
        return new JAXBElement<XmlConsoleMenuEntry>(_ConsoleMenuEntry_QNAME, XmlConsoleMenuEntry.class, null, value);
    }

    @XmlElementDecl(namespace = "http://ui.config.ns", name = "console-menu")
    public JAXBElement<XmlConsoleMenu> createConsoleMenu(XmlConsoleMenu value) {
        return new JAXBElement<XmlConsoleMenu>(_ConsoleMenu_QNAME, XmlConsoleMenu.class, null, value);
    }

}
