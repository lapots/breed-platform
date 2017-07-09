package com.lapots.breed.platform.core.repository.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="main_female_character")
public class MainFemaleCharacter {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    private Race race;
    private String name;
    private int age;
}
