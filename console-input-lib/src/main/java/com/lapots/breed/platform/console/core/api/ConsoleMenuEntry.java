package com.lapots.breed.platform.console.core.api;

import bsh.EvalError;
import bsh.Interpreter;
import com.lapots.breed.platform.console.core.AbstractConsoleMenu;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConsoleMenuEntry extends AbstractConsoleMenu {
    private static final String COMMAND_BACK = "back";

    @Override
    protected void doMenuAction() {
        // add implementation of instruction
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.eval(this.bodyActionExpr);
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
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
