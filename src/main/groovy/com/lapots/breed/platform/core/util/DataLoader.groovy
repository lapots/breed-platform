package com.lapots.breed.platform.core.util

import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter
import com.lapots.breed.platform.core.repository.domain.NPCharacter
import com.lapots.breed.platform.core.repository.domain.Race
import com.lapots.breed.platform.core.repository.domain.api.BasicCharacter
import groovy.json.JsonSlurper

class DataLoader {

    private static final String FILE_WITH_DATA = "/breed/data.json"

    def static loadRaces() {
        def resultList = []
        getClass().getResource(FILE_WITH_DATA).withReader {
            def list = new JsonSlurper().parse(it).races
            list.each { entry ->
                resultList << (entry as Race)
            }
        }

        resultList
    }

    def static loadNpc() {
        def resultList = []
        getClass().getResource(FILE_WITH_DATA).withReader {
            def list = new JsonSlurper().parse(it).npc
            list.each { entry ->

                NPCharacter character = new NPCharacter()
                character = loadAsBasicCharacter(character, entry)

                resultList << character
            }
        }

        resultList
    }

    def static playableCharacter(String file) {
        def resultList = []
        getClass().getResource(FILE_WITH_DATA).withReader {
            def list = new JsonSlurper().parse(it).mainCharacters
            list.each { entry ->

                MainFemaleCharacter character = new MainFemaleCharacter()
                character = loadAsBasicCharacter(character, entry)

                resultList << character

            }
        }

        resultList
    }

    private def static loadAsBasicCharacter(BasicCharacter character, entry) {
        !entry.id ?: { character.id = UUID.fromString(entry.id) }()
        character.age = Integer.valueOf(entry.age)
        character.name = entry.name
        character.race = Race.valueOf(entry.race)
        character
    }
}
