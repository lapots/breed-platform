package com.lapots.breed.platform.core.repository.domain;

import com.lapots.breed.platform.core.repository.domain.api.UidNamedObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="race")
@EqualsAndHashCode(callSuper = true)
public @Data class Race extends UidNamedObject {
}
