package com.lapots.breed.platform.guice;

import com.google.inject.AbstractModule;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IRacesRepository.class).to(RacesRepository.class);
    }
}
