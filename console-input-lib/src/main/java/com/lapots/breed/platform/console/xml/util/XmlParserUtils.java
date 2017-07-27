package com.lapots.breed.platform.console.xml.util;

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

public final class XmlParserUtils {

    @SuppressWarnings("unchecked")
    public static ConsoleController parseXmlConsoleTemplate(String path, ConsoleController ref) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            try (InputStream is = classPathResource(path)) {
                XmlConsoleMenu xmlConsoleMenu =
                        ((JAXBElement<XmlConsoleMenu>) unmarshaller.unmarshal(is)).getValue();
                ref.setQuitCommand(xmlConsoleMenu.getQuitCommand());
                xmlConsoleMenu.getConsoleMenuEntry()
                        .forEach(menuEntry -> {
                            ConsoleMenuEntry consoleMenuEntry = new ConsoleMenuEntry();
                            consoleMenuEntry.setLabel(menuEntry.getText());
                            ref.putEntry(menuEntry.getIndex().toString(), consoleMenuEntry);

                            if (!menuEntry.getContent().isEmpty()) {
                                processXmlConsoleMenuEntry(menuEntry, consoleMenuEntry);
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return ref;
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
                body.setBodyActionExpression(onActionExpr);
            }
        }
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
