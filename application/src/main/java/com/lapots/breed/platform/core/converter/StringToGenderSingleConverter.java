package com.lapots.breed.platform.core.converter;

import com.lapots.breed.platform.core.domain.Gender;
import com.lapots.breed.platform.core.repository.GenderRepository;
import com.lapots.breed.platform.core.repository.api.IGenderRepository;
import com.lapots.breed.platform.json.core.api.IJsonSingleConverter;

public class StringToGenderSingleConverter implements IJsonSingleConverter<String, Gender> {

    private IGenderRepository genderRepository = new GenderRepository();

    @Override
    public Gender convert(String object) {
        return genderRepository.getGenderByName(object);
    }
}
