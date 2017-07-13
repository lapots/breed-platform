package com.lapots.breed.platform;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.platform.core.di.RepositoryModule;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.impl.api.IRacesRepository;

public class Example {

    private Injector injector = Guice.createInjector(new RepositoryModule());

    private void execute() {
        IRacesRepository racesRepository = injector.getInstance(IRacesRepository.class);
        System.out.println("List of races: " + racesRepository.readRaces());
    }

    public static void main(String[] args) {
        new Example().execute();

        Hibernate.CONTEXT.stopHibernate();
    }
}
