package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.api.AbstractConsoleMenuEntry;
import com.lapots.breed.platform.core.repository.domain.MainCharacter;

import java.io.BufferedReader;
import java.io.IOException;

public class CharacterCreationConsoleMenuEntry extends AbstractConsoleMenuEntry {

    public CharacterCreationConsoleMenuEntry(String label) {
        super(label);
    }

    @Override
    public void proceedEntryAction(BufferedReader br) {
        this.br = br;
        System.out.println("Create your character.");

        MainCharacter character = new MainCharacter();
        try {
            System.out.print("Choose gender: >");
            String input = br.readLine();
            //character.setGender(genderRepository.getGenderByName(input));

            System.out.print("Choose name:> ");
            input = br.readLine();
            character.setName(input);

            System.out.print("Choose race:> ");
            input = br.readLine();
            //character.setRace(racesRepository.getRaceByName(input));

            System.out.print("Choose age:> ");
            input = br.readLine();
            character.setAge(Integer.valueOf(input));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Created character: " + character);
        // characterRepository.insertCharacter(character);
    }
}
