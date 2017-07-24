package com.lapots.breed.platform.console.sample;

import com.lapots.breed.platform.console.core.ConsoleController;
import com.lapots.breed.platform.console.core.api.ConsoleMenuEntry;
import com.lapots.breed.platform.console.core.api.IConsoleInputHandler;
import com.lapots.breed.platform.console.xml.ObjectFactory;
import com.lapots.breed.platform.console.xml.XmlConsoleMenu;
import com.lapots.breed.platform.console.xml.XmlConsoleMenuEntry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            ConsoleController controller = new ConsoleController();
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            // process xml
            try (InputStream is = classPathResource("/xml/ui-config.xml")) {
                XmlConsoleMenu xmlConsoleMenu =
                        ((JAXBElement<XmlConsoleMenu>) unmarshaller.unmarshal(is)).getValue();
                System.out.println("Parsed entries: " + xmlConsoleMenu.getConsoleMenuEntry().size());
                xmlConsoleMenu.getConsoleMenuEntry()
                        .forEach(menuEntry -> processXmlConsoleMenuEntry(menuEntry, controller));

            } catch (IOException e) {
                e.printStackTrace();
            }

            controller.listEntries();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void processXmlConsoleMenuEntry(XmlConsoleMenuEntry menuEntry, IConsoleInputHandler body) {
        for (Serializable element : menuEntry.getContent()) {
            if (element instanceof JAXBElement) {
                System.out.println("Found entry element");
                XmlConsoleMenuEntry xmlConsoleMenuEntry = ((JAXBElement<XmlConsoleMenuEntry>) element).getValue();
                ConsoleMenuEntry consoleMenuEntry = new ConsoleMenuEntry();
                consoleMenuEntry.setLabel(xmlConsoleMenuEntry.getText());
                body.putEntry(xmlConsoleMenuEntry.getIndex().toString(), consoleMenuEntry);

                processXmlConsoleMenuEntry(xmlConsoleMenuEntry, consoleMenuEntry);
            } else if (element instanceof String) {
                String onActionExpr = element.toString().trim();
                System.out.println("Expected action on invokation: " + onActionExpr);
            }
        }
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
