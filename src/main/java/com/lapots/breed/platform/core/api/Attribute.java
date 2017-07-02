package com.lapots.breed.platform.core.api;

import lombok.Data;

public @Data class Attribute {
    private Object attribute;

    public Attribute(Object attribute) {
        this.attribute = attribute;
    }
}
