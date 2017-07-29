package com.lapots.breed.platform.json.sample;

import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;

public interface INameRepository extends IJsonProcessableRepository {
    NameDomain read(String name);
    void write(NameDomain domain);
}
