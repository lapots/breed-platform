package com.lapots.breed.platform.console.core.api;

import com.lapots.breed.platform.console.core.AbstractConsoleMenu;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConsoleMenuEntry extends AbstractConsoleMenu {
    private static final String COMMAND_BACK = "back";

    @Override
    protected void doMenuAction() {
        System.out.println(this.bodyActionExpr);
    }

    @Override
    protected boolean isInLoop() {
        if (commandStack.isEmpty()) {
            return false;
        }
        String command = commandStack.pop();
        return COMMAND_BACK.equals(command);
    }
}
