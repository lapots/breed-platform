package com.lapots.breed.platform.core.util

class MainFemaleCharacterBuilder {

    def static setField(mainFemaleCharacter, name, value) {
        mainFemaleCharacter."$name" = value
        mainFemaleCharacter
    }

}
