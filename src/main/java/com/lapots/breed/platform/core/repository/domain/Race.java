package com.lapots.breed.platform.core.repository.domain;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.api.UidNamedObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="race")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public @Data class Race extends UidNamedObject {

    public static Race valueOf(String race) {
        Race dbRace = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();

            String hsql = "from Race where name= :name";
            Query query = session.createQuery(hsql);
            query.setParameter("name", race);
            dbRace = (Race) query.uniqueResult();

            session.getTransaction().commit();
        }

        return dbRace;
    }
}
