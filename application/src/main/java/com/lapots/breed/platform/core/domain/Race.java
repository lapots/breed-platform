package com.lapots.breed.platform.core.domain;

import com.lapots.breed.platform.core.domain.api.UidNamedObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="race")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public @Data class Race extends UidNamedObject {
}
