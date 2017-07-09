package com.lapots.breed.platform.core.util

import com.lapots.breed.platform.core.repository.domain.Race
import groovy.json.JsonSlurper

class RacesLoader {

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

}
