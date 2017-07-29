package com.lapots.breed.platform.json.sample;

import com.lapots.breed.platform.json.ConsoleMenuRunner;

public class Main {

    public static void main(String[] args) {
        ConsoleMenuRunner runner = new ConsoleMenuRunner("/xml/ui-config.xml");
        runner.run();
    }
}
