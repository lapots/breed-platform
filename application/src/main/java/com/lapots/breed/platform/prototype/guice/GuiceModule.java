package com.lapots.breed.platform.prototype.guice;

import com.google.inject.AbstractModule;
import com.lapots.breed.platform.prototype.IPersonRepository;
import com.lapots.breed.platform.prototype.IRaceRepository;
import com.lapots.breed.platform.prototype.PersonRepository;
import com.lapots.breed.platform.prototype.RaceRepository;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IPersonRepository.class).to(PersonRepository.class);
        bind(IRaceRepository.class).to(RaceRepository.class);
    }
}

