package com.lapots.breed.platform.prototype;

public class PersonRepository
        implements IPersonRepository {
    @Override
    public BasicPerson getPerson(String id) {
        return new BasicPerson(id, "Charlie", "HUMAN");
    }
}
