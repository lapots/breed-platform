package com.lapots.breed.dialog.core

import groovy.transform.ToString

@ToString
class DialogFlow {
    String dialogId
    String phraseBankId
    List<DialogPhrase> phrases
}
