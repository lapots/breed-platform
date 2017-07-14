package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.MainCharacter;

import java.util.List;

public interface IMainCharacterRepository {
    void insertCharacterBatch(List<MainCharacter> batch);
    List<MainCharacter> readCharacters();
    void insertCharacter(MainCharacter character);
    MainCharacter getCharacter(String id);
}
