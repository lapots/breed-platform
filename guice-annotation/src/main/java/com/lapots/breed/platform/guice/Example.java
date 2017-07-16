package com.lapots.breed.platform.guice;

import com.lapots.breed.platform.guice.annotation.GuiceInject;

public class Example {
    @GuiceInject(module=RepositoryModule.class)
    private IRacesRepository racesRepository;

    private void execute() {
        System.out.println("List of races: " + racesRepository.readRaces());
    }

    public static void main(String[] args) {
        new Example().execute();
    }
}
