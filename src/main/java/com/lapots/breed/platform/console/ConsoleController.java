package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.api.IConsoleInputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConsoleController {
    private static final String QUIT_CMD = "quit";
    private static final String QUIT_CMD_MSG = "Press %s to EXIT";
    private Map<String, IConsoleInputHandler> menuEntries = new LinkedHashMap<>();
    private Integer persistentEntryIndex = 0;

    public void loop() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            while (!QUIT_CMD.equals(line)) {
                System.out.println(String.format(QUIT_CMD_MSG, QUIT_CMD));
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

    public void addEntry(IConsoleInputHandler handler) {
        persistentEntryIndex++;
        menuEntries.put(persistentEntryIndex.toString(), handler);
    }

    private void handleInput(String menuEntry, BufferedReader br) {
        IConsoleInputHandler handler = menuEntries.get(menuEntry);
        if (null == handler) {
            return;
        } else {
            handler.proceedEntryAction(br);
        }
    }
}
