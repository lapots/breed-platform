package com.lapots.breed.platform.core.repository.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="np_character")
public class NPCharacter {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private Race race;
    private String name;
    private int age;
}
