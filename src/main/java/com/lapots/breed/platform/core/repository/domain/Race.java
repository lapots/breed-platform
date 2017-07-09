package com.lapots.breed.platform.core.repository.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="race")
public class Race {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}
