package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.MainFemaleCharacter;

import java.util.List;

public interface IMainFemaleCharacterRepository {
    List<MainFemaleCharacter> listCharacters();
    void saveCharacter(MainFemaleCharacter character);
}
