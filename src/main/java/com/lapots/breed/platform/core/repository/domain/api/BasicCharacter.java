package com.lapots.breed.platform.core.repository.domain.api;

import com.lapots.breed.platform.core.repository.domain.Race;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
public @Data class BasicCharacter extends UidNamedObject {
    @OneToOne
    private Race race;
    private int age;
}
