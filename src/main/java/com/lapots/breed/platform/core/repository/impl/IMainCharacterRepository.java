package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter;

import java.util.List;

public interface IMainCharacterRepository {
    void insertCharacterBatch(List<MainFemaleCharacter> batch);
    List<MainFemaleCharacter> readCharacters();
    void insertCharacter(MainFemaleCharacter character);
    MainFemaleCharacter getCharacter(String id);
}
