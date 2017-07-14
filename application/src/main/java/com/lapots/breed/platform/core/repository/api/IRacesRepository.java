package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.Race;

import java.util.List;

public interface IRacesRepository {
    void insertRacesBatch(List<Race> batch);
    List<Race> readRaces();
    void insertRace(Race race);
    Race getRaceByName(String name);
}
