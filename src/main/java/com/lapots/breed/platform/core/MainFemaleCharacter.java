package com.lapots.breed.platform.core;

import com.lapots.breed.platform.core.api.Attribute;
import com.lapots.breed.platform.core.api.Character;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name="player_parameters")
public class MainFemaleCharacter extends Character {
    @Getter
    @Setter
    private boolean isPregnant;
    private Map<String, Attribute> pussyParameters;
}
