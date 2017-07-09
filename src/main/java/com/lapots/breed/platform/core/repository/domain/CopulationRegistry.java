package com.lapots.breed.platform.core.repository.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CopulationRegistry.CopulationRegistryKey.class)
@Table(name="copulation_registry")
public class CopulationRegistry {
    @Id
    @OneToOne
    private NPCharacter npCharacter;
    @Id
    @OneToOne
    private MainFemaleCharacter femCharacter;
    private int times;

    static class CopulationRegistryKey implements Serializable {
        private NPCharacter npCharacter;
        private MainFemaleCharacter femCharacter;
    }
}
