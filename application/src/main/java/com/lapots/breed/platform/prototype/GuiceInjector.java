package com.lapots.breed.platform.prototype;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.ArrayList;
import java.util.List;

public class GuiceInjector {
    private static Injector injector;
    private static List<Module> modules = new ArrayList<>();
    private static boolean isInit;

    public static void addModule(Module module) {
        modules.add(module);
    }

    public static <T> T getInstance(Class<T> clazz) {
        if (isInit) {
            return injector.getInstance(clazz);
        } else {
            isInit = true;
            injector = Guice.createInjector(modules);
            return injector.getInstance(clazz);
        }
    }
}

