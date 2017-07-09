package com.lapots.breed.platform.core.util

import com.lapots.breed.platform.core.repository.domain.NPCharacter
import com.lapots.breed.platform.core.repository.domain.Race
import groovy.json.JsonSlurper

class DataLoader {

    def static loadRaces(String file) {
        def resultList = []
        getClass().getResource(file).withReader {
            def list = new JsonSlurper().parse(it).races
            list.each { entry ->
                resultList << (entry as Race)
            }
        }

        resultList
    }

    def static loadNpc(String file) {
        def resultList = []
        getClass().getResource(file).withReader {
            def list = new JsonSlurper().parse(it).npc
            list.each { entry ->

                NPCharacter character = new NPCharacter()
                character.age = Integer.valueOf(entry.age)
                character.name = entry.name
                character.race = Race.valueOf(entry.race)

                resultList << character
            }
        }

        resultList
    }
}
