package com.lapots.breed.platform.json;

import com.lapots.breed.platform.json.core.JsonConversionRegistry;
import com.lapots.breed.platform.json.core.JsonParserContext;
import com.lapots.breed.platform.json.xml.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParserRunner {
    // expect this file in classpath
    private static final String META_FILE = "/json/json.meta";

    private JsonParserContext jsonParserContext = new JsonParserContext();

    public void loadDataFromFile() {
        try {
            String filename = Files.readAllLines(Paths.get(classPathURI(META_FILE))).get(0);
            processXmlFile(filename);

            jsonParserContext.doParse();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void processXmlFile(String xmlFile) {
        try (InputStream is = classPathResource(xmlFile)) {
            JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            XmlJsonConfiguration configuration =
                    ((JAXBElement<XmlJsonConfiguration>) unmarshaller.unmarshal(is)).getValue();
            processDataElement(configuration);
            processConverters(configuration.getConverters());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private void processDataElement(XmlJsonConfiguration configuration) {
        configuration.getData().forEach(dataElement -> {
            String type = dataElement.getType();
            if ("json".equals(type)) {
                processDataType(dataElement);
            }
        });
    }

    private void processDataType(XmlConfigurationData data) {
        XmlConfigurationFilePath xmlFilePathConfig = data.getFilePath();
        String jsonFilePath = xmlFilePathConfig.getValue();
        jsonParserContext.setFilePath(jsonFilePath);
        if (xmlFilePathConfig.isResourcesPath()) {
            jsonParserContext.setReadAsClasspath(true);
        }

        XmlConfigurationEntries entryList = data.getEntries();
        for (XmlConfigurationEntry entry : entryList.getEntry()) {
            jsonParserContext.putJsonParserComponent(entry.getLabel(),
                    entry.getDomainClass(), entry.getRepositoryClass());
        }
    }

    private void processConverters(XmlJsonConverters converters) {
        for (XmlJsonConverter converter : converters.getConverter()) {
            processConverter(converter);
        }
    }

    private void processConverter(XmlJsonConverter converter) {
        jsonParserContext.putConverter(converter.getFromClass(), converter.getToClass(), converter.getClazz());
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }

    private static URI classPathURI(String name) throws URISyntaxException {
        return JAXBContext.class.getResource(name).toURI();
    }
}
