package com.lapots.breed.platform.core.util;

import com.lapots.breed.platform.core.repository.domain.NPCharacter;
import com.lapots.breed.platform.core.repository.domain.Race;
import groovy.lang.GroovyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class GroovyEmbeddedRunner {

    @SuppressWarnings("unchecked")
    public static List<Race> generateRacesList() {
        return generateJsonList("loadRaces");
    }

    @SuppressWarnings("unchecked")
    public static List<NPCharacter> generateNPCList() {
        return generateJsonList("loadNpc");
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> generateJsonList(String methodName) {
        ClassLoader parent = GroovyEmbeddedRunner.class.getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(parent);
        List<T> items = null;
        try {
            Class<?> gClazz = groovyClassLoader.loadClass("com.lapots.breed.platform.core.util.DataLoader");
            Method method = gClazz.getMethod(methodName);
            items = (List<T>) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return items == null ? Collections.emptyList() : items;
    }
}
