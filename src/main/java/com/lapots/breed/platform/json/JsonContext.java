package com.lapots.breed.platform.json;

import com.owlike.genson.Genson;

public enum JsonContext {
    PARSER;

    private Genson genson = new Genson();

    public Genson getParser() {
        return genson;
    }
}
