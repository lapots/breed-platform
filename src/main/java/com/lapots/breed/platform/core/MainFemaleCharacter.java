package com.lapots.breed.platform.core;

import com.lapots.breed.platform.core.api.Attribute;
import com.lapots.breed.platform.core.api.Character;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Map;

@Entity(name="player_parameters")
@Table(name="player_parameters")
public class MainFemaleCharacter extends Character {
    @Getter
    @Setter
    private boolean isPregnant;
    @Transient
    private Map<String, Attribute> pussyParameters;
}
