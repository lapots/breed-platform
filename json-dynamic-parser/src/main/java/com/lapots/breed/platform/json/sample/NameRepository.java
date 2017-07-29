package com.lapots.breed.platform.json.sample;

public class NameRepository implements INameRepository {

    @Override
    public NameDomain read(String name) {
        return PersistentStorage.get(name);
    }

    @Override
    public void write(NameDomain domain) {
        PersistentStorage.put(domain);
    }
}
