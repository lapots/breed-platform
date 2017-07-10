package com.lapots.breed.platform.console.api;

import java.io.BufferedReader;

public abstract class AbstractConsoleMenuEntry implements IConsoleInputHandler {
    protected BufferedReader br;
    private String label;

    public AbstractConsoleMenuEntry(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
