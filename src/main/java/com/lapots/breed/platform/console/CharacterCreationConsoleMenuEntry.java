package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.api.AbstractConsoleMenuEntry;

import java.io.BufferedReader;

public class CharacterCreationConsoleMenuEntry extends AbstractConsoleMenuEntry {

    public CharacterCreationConsoleMenuEntry(String label) {
        super(label);
    }

    @Override
    public void proceedEntryAction(BufferedReader br) {
        this.br = br;
        System.out.println("Hello, character creation!");
    }
}
