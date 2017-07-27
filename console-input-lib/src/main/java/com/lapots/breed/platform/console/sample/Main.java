package com.lapots.breed.platform.console.sample;

import com.lapots.breed.platform.console.ConsoleMenuRunner;

public class Main {

    public static void main(String[] args) {
        ConsoleMenuRunner runner = new ConsoleMenuRunner("/xml/ui-config.xml");
        runner.run();
    }
}
