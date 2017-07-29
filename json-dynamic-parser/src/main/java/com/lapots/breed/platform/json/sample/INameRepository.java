package com.lapots.breed.platform.json.sample;

public interface INameRepository {
    NameDomain read(String name);
    void write(NameDomain domain);
}
