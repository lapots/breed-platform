package com.lapots.breed.platform.core.converter;

import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.core.repository.RacesRepository;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;
import com.lapots.breed.platform.json.core.api.IJsonSingleConverter;

public class StringToRaceSingleConverter implements IJsonSingleConverter<String, Race> {

    private IRacesRepository racesRepository = new RacesRepository();

    @Override
    public Race convert(String object) {
        return racesRepository.getRaceByName(object);
    }
}
