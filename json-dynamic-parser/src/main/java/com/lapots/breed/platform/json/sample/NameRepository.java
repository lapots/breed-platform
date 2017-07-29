package com.lapots.breed.platform.json.sample;

import java.util.List;

public class NameRepository implements INameRepository {

    @Override
    public NameDomain read(String name) {
        return PersistentStorage.get(name);
    }

    @Override
    public void write(NameDomain domain) {
        PersistentStorage.put(domain);
    }

    @Override
    public void insertBatch(List batch) {
        for (Object entry : batch) {
            PersistentStorage.put((NameDomain) entry);
        }
    }
}
