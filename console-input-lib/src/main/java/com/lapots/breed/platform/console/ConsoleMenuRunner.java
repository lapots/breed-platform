package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.core.ConsoleController;
import com.lapots.breed.platform.console.xml.util.XmlParserUtils;

import java.io.*;

public class ConsoleMenuRunner {
    private static final String UI_TEMPLATE_PATH = "/xml/ui-config.xml";
    private ConsoleController controller;

    public ConsoleMenuRunner() {
        controller = new ConsoleController();
    }

    public void run() {
        controller = XmlParserUtils.parseXmlConsoleTemplate(UI_TEMPLATE_PATH, controller);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            controller.proceedEntryAction(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
