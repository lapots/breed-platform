package com.lapots.breed.platform.core.repository.domain.api;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public @Data class UidNamedObject {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique=true)
    private String name;
}
