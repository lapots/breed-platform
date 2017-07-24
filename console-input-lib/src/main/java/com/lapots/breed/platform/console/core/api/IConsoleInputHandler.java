package com.lapots.breed.platform.console.core.api;

import java.io.BufferedReader;

public interface IConsoleInputHandler {
    void proceedEntryAction(BufferedReader br);

    void putEntry(String index, IConsoleInputHandler handler);

    String getLabel();
}
