package com.lapots.breed.platform.core.domain;

import com.lapots.breed.platform.core.domain.api.BasicCharacter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="np_character")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public @Data class NPCharacter extends BasicCharacter {
}
