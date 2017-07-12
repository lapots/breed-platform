package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.domain.Gender;

import java.util.List;

public interface IGenderRepository {
    void insertGendersBatch(List<Gender> batch);
    List<Gender> readGenders();
    void insertGender(Gender gender);
    Gender getGenderByName(String name);
}
