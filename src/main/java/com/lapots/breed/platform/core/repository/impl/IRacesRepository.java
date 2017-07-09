package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.domain.Race;

import java.util.List;

public interface IRacesRepository {
    void insertRacesBatch(List<Race> batch);
    List<Race> readRaces();
    void insertRace(Race race);
}
