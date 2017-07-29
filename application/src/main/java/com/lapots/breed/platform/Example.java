package com.lapots.breed.platform;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lapots.breed.platform.core.di.RepositoryModule;
import com.lapots.breed.platform.core.domain.Gender;
import com.lapots.breed.platform.core.domain.MainCharacter;
import com.lapots.breed.platform.core.domain.NPCharacter;
import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.api.IGenderRepository;
import com.lapots.breed.platform.core.repository.api.IMainCharacterRepository;
import com.lapots.breed.platform.core.repository.api.INpcRepository;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;
import com.lapots.breed.platform.core.util.json.JsonDataProcessor;

import java.util.List;

public class Example {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new RepositoryModule());

        List<Race> races = JsonDataProcessor.readJsonList("races");
        IRacesRepository racesRepository = injector.getInstance(IRacesRepository.class);
        racesRepository.insertRacesBatch(races);

        List<NPCharacter> npcs = JsonDataProcessor.readJsonList("npc");
        INpcRepository npcRepository = injector.getInstance(INpcRepository.class);
        npcRepository.insertNpcBatch(npcs);

        List<MainCharacter> mcs = JsonDataProcessor.readJsonList("mainCharacters");
        IMainCharacterRepository mainCharacterRepository = injector.getInstance(IMainCharacterRepository.class);
        mainCharacterRepository.insertCharacterBatch(mcs);

        List<Gender> genders = JsonDataProcessor.readJsonList("genders");
        IGenderRepository genderRepository = injector.getInstance(IGenderRepository.class);
        genderRepository.insertGendersBatch(genders);

        Hibernate.CONTEXT.stopHibernate();
    }
}
