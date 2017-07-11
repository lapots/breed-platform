package com.lapots.breed.platform;

import com.lapots.breed.platform.console.CharacterCreationConsoleMenuEntry;
import com.lapots.breed.platform.console.ConsoleController;
import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.Race;
import com.lapots.breed.platform.core.repository.impl.*;
import com.lapots.breed.platform.json.JsonDataProcessor;

public class Example {
    private static IRacesRepository racesRepository = new RacesRepository();
    private static INpcRepository npcRepository = new NpcRepository();
    private static IMainCharacterRepository mcRepository = new MainCharacterRepository();

    private static void prepareDb() {
        racesRepository.insertRacesBatch(JsonDataProcessor.readJsonList("races"));
        npcRepository.insertNpcBatch(JsonDataProcessor.readJsonList("npc"));

    }

    public static void main(String[] args) {
        prepareDb();
        System.out.println("Available races: " + racesRepository.readRaces());
        System.out.println("Available npcs: " + npcRepository.readNpcs());

        ConsoleController controller = new ConsoleController();
        controller.addEntry(new CharacterCreationConsoleMenuEntry("Character creation"));
        controller.loop();

        HibernateContext.INSTANCE.closeHibernateContext();
    }
}
