package com.lapots.breed.platform.json.sample;

import java.util.HashMap;
import java.util.Map;

public class PersistentStorage {
    private static Map<String, NameDomain> storage = new HashMap<>();

    public static void put(NameDomain object) {
        storage.put(object.getName(), object);
    }

    public static NameDomain get(String name) {
        return storage.get(name);
    }
}
