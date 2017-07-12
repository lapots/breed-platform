package com.lapots.breed.platform;

import com.lapots.breed.platform.console.CharacterCreationConsoleMenuEntry;
import com.lapots.breed.platform.console.ConsoleController;
import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.impl.*;
import com.lapots.breed.platform.json.JsonDataProcessor;

public class Example {
    private static IRacesRepository racesRepository = new RacesRepository();
    private static INpcRepository npcRepository = new NpcRepository();
    private static IMainCharacterRepository mcRepository = new MainCharacterRepository();
    private static IGenderRepository gdRepository = new GenderRepository();

    private static void prepareDb() {
        racesRepository.insertRacesBatch(JsonDataProcessor.readJsonList("races"));
        gdRepository.insertGendersBatch(JsonDataProcessor.readJsonList("genders"));
        npcRepository.insertNpcBatch(JsonDataProcessor.readJsonList("npc"));
        mcRepository.insertCharacterBatch(JsonDataProcessor.readJsonList("mainCharacters"));
    }

    public static void main(String[] args) {
        prepareDb();

        System.out.println("Available races: " + racesRepository.readRaces());
        System.out.println("Available npcs: " + npcRepository.readNpcs());
        System.out.println("Available mcs: " + mcRepository.readCharacters());
        System.out.println("Available genders: " + gdRepository.readGenders());

        ConsoleController controller = new ConsoleController();
        controller.addEntry(new CharacterCreationConsoleMenuEntry("Character creation"));
        controller.loop();

        HibernateContext.INSTANCE.closeHibernateContext();
    }
}
