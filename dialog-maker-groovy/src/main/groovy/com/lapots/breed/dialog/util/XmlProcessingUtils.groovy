package com.lapots.breed.dialog.util

class XmlProcessingUtils {

    def static readResource(name) {
        this.getClass().getResource(name).text
    }

    def static findByAttribute(xml, parent, attribute, value) {
        xml."$parent".'**'.find { it.@"$attribute" == value }
    }

}
