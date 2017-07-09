package com.lapots.breed.platform.core.util;

import com.lapots.breed.platform.core.repository.domain.Race;
import groovy.lang.GroovyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public class GroovyEmbeddedRunner {

    @SuppressWarnings("unchecked")
    public static List<Race> generateRacesList() {
        ClassLoader parent = GroovyEmbeddedRunner.class.getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(parent);

        List<Race> races = null;
        try {
            Class<?> gClazz = groovyClassLoader.loadClass("com.lapots.breed.platform.core.util.RacesLoader");
            Method method = gClazz.getMethod("loadRaces", String.class);
            races = (List<Race>) method.invoke(null, "races.json");
        } catch (ClassNotFoundException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return races == null ? Collections.emptyList() : races;
    }

}
