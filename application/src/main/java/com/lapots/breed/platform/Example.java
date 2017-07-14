package com.lapots.breed.platform;

import com.lapots.breed.platform.core.di.RepositoryModule;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;
import com.lapots.breed.platform.guice.annotation.GuiceInject;

public class Example {
    @GuiceInject(module=RepositoryModule.class)
    private IRacesRepository racesRepository;

    private void execute() {
        System.out.println("List of races: " + racesRepository.readRaces());
    }

    public static void main(String[] args) {
        new Example().execute();

        Hibernate.CONTEXT.stopHibernate();
    }
}
