package com.lapots.breed.platform.core.repository.module;

import com.lapots.breed.platform.core.repository.impl.*;
import com.lapots.breed.platform.core.repository.impl.api.IGenderRepository;
import com.lapots.breed.platform.core.repository.impl.api.IMainCharacterRepository;
import com.lapots.breed.platform.core.repository.impl.api.INpcRepository;
import com.lapots.breed.platform.core.repository.impl.api.IRacesRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Provides static IGenderRepository provideGenderRepository() {
        return new GenderRepository();
    }

    @Provides static IRacesRepository provideRaceRepository() {
        return new RacesRepository();
    }

    @Provides static IMainCharacterRepository provideMainCharacterRepository() {
        return new MainCharacterRepository();
    }

    @Provides static INpcRepository provideNpcRepository() {
        return new NpcRepository();
    }
}
