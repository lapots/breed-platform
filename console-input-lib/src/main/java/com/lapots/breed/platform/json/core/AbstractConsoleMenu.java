package com.lapots.breed.platform.json.core;

import com.lapots.breed.platform.json.core.api.IConsoleInputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public abstract class AbstractConsoleMenu implements IConsoleInputHandler {
    private String label;
    private Map<String, IConsoleInputHandler> menuEntries = new LinkedHashMap<>();
    // added to control console action for children
    protected Stack<String> commandStack = new Stack<>();
    protected String bodyActionExpr;

    @Override
    public void proceedEntryAction(BufferedReader br) {
        if (menuEntries.isEmpty()) {
            doMenuAction();
        } else {
            try {
                while (!isInLoop()) {
                    listEntries();
                    handleInput(br);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setBodyActionExpression(String expr) {
        this.bodyActionExpr = expr;
    }

    protected void listEntries() {
        menuEntries.forEach((key, value) -> {
            System.out.println(key + ". " + value.getLabel());
        });
    }

    protected void handleInput(BufferedReader br) throws IOException {
        String input = br.readLine();
        commandStack.add(input);
        // by default it expect [Number] of menu entry
        IConsoleInputHandler handler = menuEntries.get(input);
        if (null != handler) {
            handler.proceedEntryAction(br);
        }
    }

    /**
     * Action to fire when no sub menu for entry available.
     */
    protected abstract void doMenuAction();

    protected abstract boolean isInLoop();
}
