package com.lapots.breed.platform;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.impl.IRacesRepository;
import com.lapots.breed.platform.core.repository.impl.RacesRepository;
import com.lapots.breed.platform.core.util.GroovyEmbeddedRunner;

public class Example {
    private static IRacesRepository racesRepository = new RacesRepository();

    private static void prepareDb() {
        racesRepository.insertRacesBatch(GroovyEmbeddedRunner.generateRacesList());
    }

    public static void main(String[] args) {
        prepareDb();
        System.out.println("Available races: " + racesRepository.readRaces());
        HibernateContext.INSTANCE.closeHibernateContext();
    }
}
