package com.lapots.breed.platform.console.api;

import java.io.BufferedReader;

public interface IConsoleInputHandler {
    void proceedEntryAction(BufferedReader br);
    String getLabel();
    void setLabel(String label);
}
