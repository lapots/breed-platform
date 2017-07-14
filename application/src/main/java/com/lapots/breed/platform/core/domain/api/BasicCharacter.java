package com.lapots.breed.platform.core.domain.api;

import com.lapots.breed.platform.core.domain.Gender;
import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.core.domain.api.UidNamedObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public @Data class BasicCharacter extends UidNamedObject {
    @OneToOne
    private Race race;
    private int age;
    @OneToOne
    private Gender gender;
}
