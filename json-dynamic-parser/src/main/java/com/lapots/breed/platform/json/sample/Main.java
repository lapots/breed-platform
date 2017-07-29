package com.lapots.breed.platform.json.sample;

import com.lapots.breed.platform.json.JsonParserRunner;

public class Main {

    public static void main(String[] args) {
        JsonParserRunner runner = new JsonParserRunner();
        runner.loadDataFromFile();

        INameRepository nameRepository = new NameRepository();
        System.out.println(nameRepository.read("Michael"));
        System.out.println(nameRepository.read("Rosette"));
    }

}
