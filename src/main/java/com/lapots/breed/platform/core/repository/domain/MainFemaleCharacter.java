package com.lapots.breed.platform.core.repository.domain;

import com.lapots.breed.platform.core.repository.domain.api.BasicCharacter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="main_female_character")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public @Data class MainFemaleCharacter extends BasicCharacter {
}
