package com.lapots.breed.platform.core.console;

import com.lapots.breed.platform.console.core.api.ConsoleMenuEntry;
import com.lapots.breed.platform.console.lang.BeanShellContext;
import com.lapots.breed.platform.core.repository.RacesRepository;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;

public class DatabaseReaderConsoleMenuEntry extends ConsoleMenuEntry {
    private BeanShellContext executionContext = new BeanShellContext();

    private IRacesRepository racesRepository = new RacesRepository();

    @Override
    protected void doMenuAction() {
        executionContext.setExpr(this.bodyActionExpr);
        executionContext.setParameter("races", racesRepository);
        executionContext.run();
    }
}
