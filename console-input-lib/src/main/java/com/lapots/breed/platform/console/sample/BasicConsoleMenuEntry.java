package com.lapots.breed.platform.console.sample;

import com.lapots.breed.platform.console.lang.BeanShellContext;
import com.lapots.breed.platform.console.core.api.ConsoleMenuEntry;

public class BasicConsoleMenuEntry extends ConsoleMenuEntry {
    @Override
    protected void doMenuAction() {
        BeanShellContext evaluationContext = new BeanShellContext();
        evaluationContext.setExpr(this.bodyActionExpr);
        evaluationContext.run();
    }
}
