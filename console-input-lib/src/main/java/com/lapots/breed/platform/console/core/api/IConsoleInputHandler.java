package com.lapots.breed.platform.console.core.api;

import java.io.BufferedReader;

public interface IConsoleInputHandler {
    void proceedEntryAction(BufferedReader br);

    void putEntry(String index, IConsoleInputHandler handler);

    String getLabel();

    void setLabel(String label);

    void setBodyActionExpression(String expr);
}
