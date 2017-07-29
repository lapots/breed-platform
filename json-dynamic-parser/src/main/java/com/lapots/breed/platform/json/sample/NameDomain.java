package com.lapots.breed.platform.json.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
public @Data class NameDomain {
    @NonNull private String name;
    @NonNull private int id;
    private NameDomain domain;
}
