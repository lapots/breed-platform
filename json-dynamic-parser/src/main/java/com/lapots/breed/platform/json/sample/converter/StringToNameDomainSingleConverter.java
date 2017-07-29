package com.lapots.breed.platform.json.sample.converter;

import com.lapots.breed.platform.json.core.api.IJsonSingleConverter;
import com.lapots.breed.platform.json.sample.NameDomain;

public class StringToNameDomainSingleConverter implements IJsonSingleConverter<String, NameDomain> {
    @Override
    public NameDomain convert(String object) {
        return new NameDomain(object, 0, null);
    }
}
