package com.lapots.breed.dialog.maker

import com.lapots.breed.dialog.external.DialogSheetParser


def dialogFlow = new DialogSheetParser().parseSingleFlowSheet("/sheet-1.xml")

println dialogFlow.phrases
