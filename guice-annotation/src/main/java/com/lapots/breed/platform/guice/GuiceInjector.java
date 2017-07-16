package com.lapots.breed.platform.guice;

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

    private static void init() {
        injector = Guice.createInjector(modules);
    }

    public static <T> T getInstance(Class<T> clazz) {
        if (!isInit) {
            init();
        }

        System.out.println("Attempt to initialize " + clazz);
        return injector.getInstance(clazz);
    }
}
