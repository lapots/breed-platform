package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.MainCharacter;
import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;

import java.util.List;

public interface IMainCharacterRepository extends IJsonProcessableRepository {
    void insertCharacterBatch(List<MainCharacter> batch);
    List<MainCharacter> readCharacters();
    void insertCharacter(MainCharacter character);
    MainCharacter getCharacter(String id);
}
