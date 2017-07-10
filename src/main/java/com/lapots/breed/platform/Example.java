package com.lapots.breed.platform;

import com.lapots.breed.platform.console.CharacterCreationConsoleMenuEntry;
import com.lapots.breed.platform.console.ConsoleController;
import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.impl.INpcRepository;
import com.lapots.breed.platform.core.repository.impl.IRacesRepository;
import com.lapots.breed.platform.core.repository.impl.NpcRepository;
import com.lapots.breed.platform.core.repository.impl.RacesRepository;
import com.lapots.breed.platform.core.util.GroovyEmbeddedRunner;

public class Example {
    private static IRacesRepository racesRepository = new RacesRepository();
    private static INpcRepository npcRepository = new NpcRepository();

    private static void prepareDb() {
        racesRepository.insertRacesBatch(GroovyEmbeddedRunner.generateRacesList());
        npcRepository.insertNpcBatch(GroovyEmbeddedRunner.generateNPCList());
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
