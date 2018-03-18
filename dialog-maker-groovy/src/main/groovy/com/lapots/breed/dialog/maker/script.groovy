package com.lapots.breed.dialog.maker

import com.lapots.breed.dialog.external.DialogSheetParser


def dialogFlows = new DialogSheetParser().parseFlowSheet("/sheet-1.xml")

dialogFlows.each {
    println it.phraseBankId
}
