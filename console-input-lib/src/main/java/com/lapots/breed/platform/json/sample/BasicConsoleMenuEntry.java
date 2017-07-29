package com.lapots.breed.platform.json.sample;

import com.lapots.breed.platform.json.core.api.ConsoleMenuEntry;
import com.lapots.breed.platform.json.lang.BeanShellContext;

public class BasicConsoleMenuEntry extends ConsoleMenuEntry {
    @Override
    protected void doMenuAction() {
        BeanShellContext evaluationContext = new BeanShellContext();
        evaluationContext.setExpr(this.bodyActionExpr);
        evaluationContext.run();
    }
}
