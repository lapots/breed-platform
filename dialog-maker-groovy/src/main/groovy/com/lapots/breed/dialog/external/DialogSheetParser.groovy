package com.lapots.breed.dialog.external

import com.lapots.breed.dialog.core.DialogFlow
import com.lapots.breed.dialog.core.DialogPhrase

import static com.lapots.breed.dialog.util.XmlProcessingUtils.findByAttribute
import static com.lapots.breed.dialog.util.XmlProcessingUtils.readResource

class DialogSheetParser {

    List<DialogFlow> parseFlowSheet(String sheetFile) {
        def dialogs = new XmlSlurper().parseText(readResource(sheetFile))
        dialogs.dialog.collect { parseSingleDialogEntry(it) }
    }

    def parseSingleDialogEntry(dialog) {
        def dialogFlow = new DialogFlow(dialogId: dialog.@id)
        dialog.flow.each { flow -> // one record
            dialogFlow.phraseBankId = flow.@ref
            def bank = findByAttribute(dialog, "phrase-bank", "id", flow.@ref)
            dialogFlow.phrases = flow.children()
                    .sort { left, right -> left.@dependsOn.text() as int <=> right.@dependsOn.text() as int }
                    .collect { parseSingleFlowElement(it, bank) } as List
        }
        dialogFlow
    }

    def parseSingleFlowElement(element, bank) {
        def xmlPhrase = findByAttribute(bank, "phrase", "id", element.text())
        new DialogPhrase(
            phraseBankId: bank.@id,
            speakerId: xmlPhrase.@speaker,
            text: xmlPhrase.text(),
            language: xmlPhrase.@language
        )
    }
}
