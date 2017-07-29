package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;

import java.util.List;

public interface IRacesRepository extends IJsonProcessableRepository {
    void insertRacesBatch(List<Race> batch);
    List<Race> readRaces();
    void insertRace(Race race);
    Race getRaceByName(String name);
}
