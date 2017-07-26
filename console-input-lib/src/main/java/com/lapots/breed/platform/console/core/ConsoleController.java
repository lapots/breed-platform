package com.lapots.breed.platform.console.core;

import com.lapots.breed.platform.console.core.api.IConsoleInputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleController implements IConsoleInputHandler {
    private static final String QUIT_CMD_MSG = "Print [ %s ] to EXIT";
    private Map<String, IConsoleInputHandler> menuEntries = new LinkedHashMap<>();

    private String quitCommand;

    public void loop() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while (!quitCommand.equals(line)) {
                System.out.println(String.format(QUIT_CMD_MSG, quitCommand));
                menuEntries.forEach((key, value) -> {
                    System.out.println(key + "." + value.getLabel());
                });
                line = br.readLine();
                handleInput(line, br);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setQuitCommand(String cmd) {
        this.quitCommand = cmd;
    }

    public void listEntries() {
        System.out.println("Menu template =>");
        menuEntries.forEach((key, value) -> {
            System.out.println(key + ". " + value.getLabel());
        });
    }
    @Override
    public void proceedEntryAction(BufferedReader br) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putEntry(String index, IConsoleInputHandler handler) {
        menuEntries.put(index, handler);
    }

    @Override
    public String getLabel() {
        throw new UnsupportedOperationException();
    }

    private void handleInput(String menuEntry, BufferedReader br) {
        IConsoleInputHandler handler = menuEntries.get(menuEntry);
        if (null != handler) {
            handler.proceedEntryAction(br);
        }
    }
}
