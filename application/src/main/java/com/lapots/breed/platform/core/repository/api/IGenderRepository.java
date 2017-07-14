package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.Gender;

import java.util.List;

public interface IGenderRepository {
    void insertGendersBatch(List<Gender> batch);
    List<Gender> readGenders();
    void insertGender(Gender gender);
    Gender getGenderByName(String name);
}
