package com.lapots.breed.platform.core.repository.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// @Entity
@Table(name="copulation_registry")
public class CopulationRegistry {
    @OneToOne
    private NPCharacter npCharacter;
    @OneToOne
    private MainFemaleCharacter femCharacter;
    private int times;
}
