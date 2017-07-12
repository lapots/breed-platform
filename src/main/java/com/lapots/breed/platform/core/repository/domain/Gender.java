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
public @Data class Gender extends UidNamedObject {

    public static Gender valueOf(String gender) {
        Gender dbGender = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();

            String hsql = "from Gender where name= :name";
            Query query = session.createQuery(hsql);
            query.setParameter("name", gender);
            dbGender = (Gender) query.uniqueResult();

            session.getTransaction().commit();
        }

        return dbGender;
    }
}
