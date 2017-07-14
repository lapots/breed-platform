package com.lapots.breed.platform.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.ArrayList;
import java.util.List;

public class GuiceInjector {
    private Injector injector;

    private GuiceInjector(Injector injector) {
        this.injector = injector;
    }

    public Injector getInjector() {
        return injector;
    }

    public static class GuiceInjectorBuilder {
        private List<Module> injectors = new ArrayList<>();
        public GuiceInjectorBuilder withModule(Module module) {
            injectors.add(module);
            return this;
        }

        public GuiceInjector build() {
            return new GuiceInjector(Guice.createInjector(injectors));
        }
    }
}
