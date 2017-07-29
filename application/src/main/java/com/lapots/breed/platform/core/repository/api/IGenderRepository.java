package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.Gender;
import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;

import java.util.List;

public interface IGenderRepository extends IJsonProcessableRepository {
    void insertGendersBatch(List<Gender> batch);
    List<Gender> readGenders();
    void insertGender(Gender gender);
    Gender getGenderByName(String name);
}
