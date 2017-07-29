package com.lapots.breed.platform.json.core;

import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;
import com.owlike.genson.Genson;
import com.owlike.genson.stream.ObjectReader;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.JAXBContext;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

public class JsonParserContext {
    private String filePath;
    private boolean readAsClasspath;

    private Map<String, JsonParserComponent> parserComponentMap = new HashMap<>();
    private Genson genson = new Genson();

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setReadAsClasspath(boolean readAsClasspath) {
        this.readAsClasspath = readAsClasspath;
    }

    public void putJsonParserComponent(String label, String domainClass, String repositoryClass) {
        JsonParserComponent component = new JsonParserComponent(repositoryClass, domainClass);
        parserComponentMap.put(label, component);
    }

    public void doParse() {
        if (readAsClasspath) {
            try (InputStream is = classPathResource(filePath)) {
                ObjectReader reader = genson.createReader(is);
                reader.beginObject();
                while (reader.hasNext()) {
                    reader.next();
                    String key = reader.name();
                    JsonParserComponent parserComponent = parserComponentMap.get(key);
                    if (null != parserComponent) {
                        processJsonEntryData(reader, parserComponent);
                    } else {
                        // ignore if no parser component found
                        reader.skipValue();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processJsonEntryData(ObjectReader reader, JsonParserComponent component) {
        List dataList = new ArrayList();
        // process list of data objects
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            try {
                Class<?> domainClass = Class.forName(component.getDomainClass());
                Object domainObject = domainClass.newInstance();

                // process data entry
                reader.beginObject();
                while (reader.hasNext()) {
                    reader.next();

                    try {
                        Field field = domainClass.getDeclaredField(reader.name());
                        field.setAccessible(true);
                        field.set(domainObject, convertStringToType(reader.valueAsString(), field.getType()));
                    } catch (NoSuchFieldException e) {
                        reader.skipValue();
                    }
                }
                reader.endObject();

                dataList.add(domainObject);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        reader.endArray();

        // load data to storage
        try {
            IJsonProcessableRepository repository =
                    (IJsonProcessableRepository) Class.forName(component.getRepositoryClass())
                            .newInstance();
            repository.insertBatch(dataList);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object convertStringToType(String input, Class<?> expected) {
        if (expected == String.class) {
            return input;
        } else if (expected == int.class || expected == Integer.class) {
            return Integer.valueOf(input);
        } else if (expected == UUID.class) {
            return UUID.fromString(input);
        }

        return null;
    }

    @Data
    @AllArgsConstructor
    private class JsonParserComponent {
        private String repositoryClass;
        private String domainClass;
    }

    private static InputStream classPathResource(String name) {
        return JAXBContext.class.getResourceAsStream(name);
    }
}
