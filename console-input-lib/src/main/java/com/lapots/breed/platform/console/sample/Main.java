package com.lapots.breed.platform.console.sample;

import com.lapots.breed.platform.console.xml.XmlConsoleMenu;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(XmlConsoleMenu.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            try (InputStream is = classPathResource("/ui-config.xml")) {
                XmlConsoleMenu xmlConsoleMenu = (XmlConsoleMenu) unmarshaller.unmarshal(is);
                System.out.println(xmlConsoleMenu);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
