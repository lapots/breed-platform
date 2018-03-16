package com.lapots.breed.dialog.maker


def dialogSheet = new XmlSlurper().parseText(readResource("/sheet-1.xml"))
println dialogSheet.@id

def readResource(name) {
    this.getClass().getResource(name).text
}