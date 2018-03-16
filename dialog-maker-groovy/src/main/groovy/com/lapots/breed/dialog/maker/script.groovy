package com.lapots.breed.dialog.maker

import com.lapots.breed.dialog.core.DialogFlow
import com.lapots.breed.dialog.core.DialogPhrase


def dialogSheet = new XmlSlurper().parseText(readResource("/sheet-1.xml"))

def dialogFlow = new DialogFlow(dialogId: dialogSheet.@id)
// convert
dialogSheet.flow.each { flow -> // one record
    dialogFlow.phraseBankId = flow.@ref
    def bank = findByAttribute(dialogSheet, "phrase-bank", "id", flow.@ref)
    dialogFlow.phrases = flow.children()
        .sort { left, right -> left.@dependsOn.text() as int <=> right.@dependsOn.text() as int }
        .collect { flow_element ->
            // find & read phrase bank
            println flow_element
            def phraseId = flow_element.text()
            def xmlPhrase = bank.phrase.'**'.find { phrs -> phrs.@id == phraseId }

            def phrase = new DialogPhrase()
            phrase.with {
                phrase.phraseBankId = flow.@ref
                phrase.speakerId = xmlPhrase.@speaker
                phrase.text = xmlPhrase.text()
                phrase.language = xmlPhrase.@language
            }

            phrase
        } as List
}

println dialogFlow.phrases

def readResource(name) {
    this.getClass().getResource(name).text
}

def findByAttribute(xml, parent, attribute, value) {
    xml."$parent".'**'.find { it.@"$attribute" == value }
}