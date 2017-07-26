package com.lapots.breed.platform.console.core.api;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
public class ConsoleMenuEntry implements IConsoleInputHandler {
    protected BufferedReader br;
    private String label;
    private Map<String, IConsoleInputHandler> menuEntries = new LinkedHashMap<>();
    private boolean doLoop = true;

    public ConsoleMenuEntry(String label) {
        this.label = label;
    }

    @Override
    public void proceedEntryAction(BufferedReader br) {
        if (menuEntries.isEmpty()) {
            // perform menu entry action
        } else {
            try {
                String line = null;
                while (doLoop) {
                    menuEntries.forEach((key, value) -> {
                        System.out.println(key + "." + value.getLabel());
                    });
                    line = br.readLine();
                    handleInput(line, br);
                }

                doLoop = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(String menuEntry, BufferedReader br) {
        IConsoleInputHandler handler = menuEntries.get(menuEntry);
        if (null != handler) {
            handler.proceedEntryAction(br);
            doLoop = false;
        }
    }

    @Override
    public void putEntry(String index, IConsoleInputHandler handler) {
        menuEntries.put(index, handler);
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
