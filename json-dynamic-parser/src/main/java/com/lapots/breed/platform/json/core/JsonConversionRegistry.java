package com.lapots.breed.platform.json.core;

import com.lapots.breed.platform.json.core.api.IJsonSingleConverter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class JsonConversionRegistry {
    private Map<JsonConverter, String> converters = new HashMap<>();

    public void addConverter(String from, String to, String converterClass) {
        converters.put(new JsonConverter(from, to), converterClass);
    }

    public Object convert(String from, String to, Object value) {
        String converterClass = converters.get(new JsonConverter(from , to));
        if (null == converterClass) {
            return null;
        } else {
            try {
                IJsonSingleConverter converter = (IJsonSingleConverter) Class.forName(converterClass).newInstance();
                return converter.convert(value);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @AllArgsConstructor
    private @Data class JsonConverter {
        private String from;
        private String to;
    }
}
