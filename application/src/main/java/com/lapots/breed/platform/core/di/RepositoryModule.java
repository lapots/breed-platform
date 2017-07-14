package com.lapots.breed.platform.core.di;

import com.google.inject.AbstractModule;
import com.lapots.breed.platform.core.repository.GenderRepository;
import com.lapots.breed.platform.core.repository.MainCharacterRepository;
import com.lapots.breed.platform.core.repository.NpcRepository;
import com.lapots.breed.platform.core.repository.RacesRepository;
import com.lapots.breed.platform.core.repository.api.IGenderRepository;
import com.lapots.breed.platform.core.repository.api.IMainCharacterRepository;
import com.lapots.breed.platform.core.repository.api.INpcRepository;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IGenderRepository.class).to(GenderRepository.class);
        bind(IRacesRepository.class).to(RacesRepository.class);
        bind(IMainCharacterRepository.class).to(MainCharacterRepository.class);
        bind(INpcRepository.class).to(NpcRepository.class);
    }
}
