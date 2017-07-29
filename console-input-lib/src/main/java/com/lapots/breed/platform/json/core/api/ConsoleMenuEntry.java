package com.lapots.breed.platform.json.core.api;

import com.lapots.breed.platform.json.core.AbstractConsoleMenu;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class ConsoleMenuEntry extends AbstractConsoleMenu {
    private static final String COMMAND_BACK = "back";

    @Override
    protected boolean isInLoop() {
        if (commandStack.isEmpty()) {
            return false;
        }
        String command = commandStack.pop();
        return COMMAND_BACK.equals(command);
    }
}
