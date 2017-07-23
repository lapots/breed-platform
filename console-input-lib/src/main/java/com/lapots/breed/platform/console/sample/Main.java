package com.lapots.breed.platform.console.sample;

import com.lapots.breed.platform.console.ConsoleController;
import com.lapots.breed.platform.console.api.ConsoleMenuEntry;
import com.lapots.breed.platform.console.xml.XmlConsoleMenu;
import com.lapots.breed.platform.console.xml.XmlConsoleMenuEntry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(XmlConsoleMenu.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            ConsoleController controller = new ConsoleController();

            // process xml
            try (InputStream is = classPathResource("/ui-config.xml")) {
                XmlConsoleMenu xmlConsoleMenu = (XmlConsoleMenu) unmarshaller.unmarshal(is);

                controller.setQuitCommand(xmlConsoleMenu.getQuitCommand());
                for (XmlConsoleMenuEntry xmlEntry: xmlConsoleMenu.getEntries()) {
                    ConsoleMenuEntry entry = new ConsoleMenuEntry(xmlEntry.getText());
                    // xmlEntry.getEntries(); process recursively
                    controller.putEntry(xmlEntry.getIndex(), entry);
                }

                controller.loop();
            } catch (IOException e) {
                e.printStackTrace();
            }

            controller.loop();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
