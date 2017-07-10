package com.lapots.breed.platform.core.util;

import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter;
import com.lapots.breed.platform.core.repository.domain.NPCharacter;
import com.lapots.breed.platform.core.repository.domain.Race;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

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

    public static <T> MainFemaleCharacter femaleCharacterBuilder(String name, T value, MainFemaleCharacter input) {
        ClassLoader parent = GroovyEmbeddedRunner.class.getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(parent);
        try {
            Class<?> gClazz =
                    groovyClassLoader.loadClass("com.lapots.breed.platform.core.util.MainFemaleCharacterBuilder");
            Method method = gClazz.getMethod("setField");
            Object[] args = {input, name, value};
            return (MainFemaleCharacter) method.invoke(null, args);
        } catch (ClassNotFoundException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
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
