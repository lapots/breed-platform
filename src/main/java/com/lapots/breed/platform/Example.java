package com.lapots.breed.platform;

import com.lapots.breed.platform.core.MainFemaleCharacter;
import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.MainFemaleCharacterRepository;
import com.lapots.breed.platform.core.repository.api.IMainFemaleCharacterRepository;

public class Example {

    private static final String PLAYERS = "from player_parameters";

    public static void main(String[] args) {
        IMainFemaleCharacterRepository characterRepository = new MainFemaleCharacterRepository();
        System.out.println("List of female characters: " + characterRepository.listCharacters());

        MainFemaleCharacter femaleCharacter = new MainFemaleCharacter();
        femaleCharacter.setName("Jessica");
        femaleCharacter.setPregnant(false);
        femaleCharacter.setAge(17);
        femaleCharacter.setRace("human");
        characterRepository.saveCharacter(femaleCharacter);

        System.out.println("List of female characters: " + characterRepository.listCharacters());

        HibernateContext.INSTANCE.closeHibernateContext();
    }
}
