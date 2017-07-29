package com.lapots.breed.platform.json.sample;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public @Data class NameDomain {
    @NonNull private String name;
}
