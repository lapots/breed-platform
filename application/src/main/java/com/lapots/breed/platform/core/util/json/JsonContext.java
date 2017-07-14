package com.lapots.breed.platform.core.util.json;

import com.owlike.genson.Genson;

public enum JsonContext {
    PARSER;

    private Genson genson = new Genson();

    public Genson getParser() {
        return genson;
    }
}
