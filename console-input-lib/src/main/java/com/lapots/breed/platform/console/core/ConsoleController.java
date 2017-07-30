package com.lapots.breed.platform.console.core;

public class ConsoleController extends AbstractConsoleMenu {
    private static final String QUIT_CMD_MSG = "Print [ %s ] to EXIT";
    private String quitCommand;

    public void setQuitCommand(String cmd) {
        this.quitCommand = cmd;
    }

    @Override
    protected void listEntries() {
        System.out.println(String.format(QUIT_CMD_MSG, quitCommand));
        super.listEntries();
    }

    @Override
    public String getLabel() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doMenuAction() {
        throw new UnsupportedOperationException("No menu entries specified");
    }

    @Override
    protected boolean isInLoop() {
        if (commandStack.isEmpty()) {
            return false;
        }

        String command = commandStack.pop();
        return quitCommand.equals(command);
    }

}
