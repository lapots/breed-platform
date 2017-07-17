package com.lapots.breed.platform.prototype;

import lombok.AllArgsConstructor;

import javax.inject.Inject;

@AllArgsConstructor
public class PersonService {
    @Inject
    private IRaceRepository raceRepository;
    @Inject
    private IPersonRepository personRepository;

    public Person findPerson(String id) {
        BasicPerson storedPerson = personRepository.getPerson(id);
        return new Person(storedPerson.getName(), raceRepository.getRaceById(storedPerson.getRaceId()));
    }
}
