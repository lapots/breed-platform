package com.lapots.breed.platform.guice;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class RacesRepository implements IRacesRepository {
    @Override
    public List<Object> readRaces() {
        return Collections.emptyList();
    }
}
