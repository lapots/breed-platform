package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.api.AbstractConsoleMenuEntry;
import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter;
import com.lapots.breed.platform.core.util.GroovyEmbeddedRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CharacterCreationConsoleMenuEntry extends AbstractConsoleMenuEntry {

    private List<String> creationSteps = Arrays.asList();

    public CharacterCreationConsoleMenuEntry(String label) {
        super(label);
    }

    @Override
    public void proceedEntryAction(BufferedReader br) {
        this.br = br;
        System.out.println("Create your character.");

        MainFemaleCharacter character = new MainFemaleCharacter();
        //creationSteps.forEach(step -> {
        // System.out.println(step);
        try {
            System.out.print("Choose name:> "); // check uniqueness
            String input = br.readLine();
            GroovyEmbeddedRunner.femaleCharacterBuilder("name", input, character);
            System.out.print("Choose race:> ");
            input = br.readLine();
            GroovyEmbeddedRunner.femaleCharacterBuilder("race", input, character);
            System.out.print("Choose age: >");
            input = br.readLine();
            GroovyEmbeddedRunner.femaleCharacterBuilder("age", input, character);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //});

        System.out.println("Created character: " + character);
    }
}
