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
                controller.setQuitCommand(xmlConsoleMenu.getQuitCommand());
                xmlConsoleMenu.getConsoleMenuEntry()
                        .forEach(menuEntry -> {
                            ConsoleMenuEntry consoleMenuEntry = new ConsoleMenuEntry();
                            consoleMenuEntry.setLabel(menuEntry.getText());
                            controller.putEntry(menuEntry.getIndex().toString(), consoleMenuEntry);

                            if (!menuEntry.getContent().isEmpty()) {
                                processXmlConsoleMenuEntry(menuEntry, consoleMenuEntry);
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }

            controller.loop();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void processXmlConsoleMenuEntry(XmlConsoleMenuEntry menuEntry, IConsoleInputHandler body) {
        for (Serializable element : menuEntry.getContent()) {
            if (element instanceof JAXBElement) {
                XmlConsoleMenuEntry xmlConsoleMenuEntry = ((JAXBElement<XmlConsoleMenuEntry>) element).getValue();
                ConsoleMenuEntry consoleMenuEntry = new ConsoleMenuEntry();
                consoleMenuEntry.setLabel(xmlConsoleMenuEntry.getText());
                body.putEntry(xmlConsoleMenuEntry.getIndex().toString(), consoleMenuEntry);

                processXmlConsoleMenuEntry(xmlConsoleMenuEntry, consoleMenuEntry);
            } else if (element instanceof String) {
                String onActionExpr = element.toString().trim();
            }
        }
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
