package com.lapots.breed.platform;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.platform.console.ConsoleMenuRunner;
import com.lapots.breed.platform.core.di.RepositoryModule;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.api.INpcRepository;
import com.lapots.breed.platform.json.JsonParserRunner;

public class Example {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RepositoryModule());
        new JsonParserRunner().loadDataFromFile();
        new ConsoleMenuRunner().run();

        INpcRepository npcRepository = injector.getInstance(INpcRepository.class);
        System.out.println(npcRepository.readNpcs());

        Hibernate.CONTEXT.stopHibernate();
    }
}
