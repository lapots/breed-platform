package com.lapots.breed.platform.json;

import com.owlike.genson.Genson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JsonParserRunner {
    // expect this file in classpath
    private static final String META_FILE = "/json/json.meta";

    private Genson genson = new Genson();

    public void loadDataFromFile() {
        // read path to xml file
        try (InputStream is = new FileInputStream(META_FILE)) {
            String filename = null;
            processXmlFile(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processXmlFile(String xmlFile) {
        try (InputStream is = new FileInputStream(xmlFile)) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
