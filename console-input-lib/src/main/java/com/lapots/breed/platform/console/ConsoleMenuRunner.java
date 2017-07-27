package com.lapots.breed.platform.console;

import com.lapots.breed.platform.console.core.ConsoleController;
import com.lapots.breed.platform.console.xml.util.XmlParserUtils;

import java.io.*;

public class ConsoleMenuRunner {
    private String uiTemplatePath;
    private ConsoleController controller;

    public ConsoleMenuRunner(String uiTemplatePath) {
        this.uiTemplatePath = uiTemplatePath;
        controller = new ConsoleController();
    }

    public void run() {
        controller = XmlParserUtils.parseXmlConsoleTemplate(uiTemplatePath, controller);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            controller.proceedEntryAction(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
