package com.lapots.breed.platform.core.di;

import com.google.inject.AbstractModule;
import com.lapots.breed.platform.core.repository.impl.GenderRepository;
import com.lapots.breed.platform.core.repository.impl.MainCharacterRepository;
import com.lapots.breed.platform.core.repository.impl.NpcRepository;
import com.lapots.breed.platform.core.repository.impl.RacesRepository;
import com.lapots.breed.platform.core.repository.impl.api.IGenderRepository;
import com.lapots.breed.platform.core.repository.impl.api.IMainCharacterRepository;
import com.lapots.breed.platform.core.repository.impl.api.INpcRepository;
import com.lapots.breed.platform.core.repository.impl.api.IRacesRepository;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IGenderRepository.class).to(GenderRepository.class);
        bind(IRacesRepository.class).to(RacesRepository.class);
        bind(IMainCharacterRepository.class).to(MainCharacterRepository.class);
        bind(INpcRepository.class).to(NpcRepository.class);
    }
}
