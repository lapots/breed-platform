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
    private MainCharacter character;
    private int times;

    static class CopulationRegistryKey implements Serializable {
        private NPCharacter npCharacter;
        private MainCharacter character;
    }
}
