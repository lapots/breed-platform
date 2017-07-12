package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.domain.Gender;
import com.lapots.breed.platform.core.repository.impl.api.IGenderRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.util.List;

public class GenderRepository implements IGenderRepository {
    @Inject
    public Hibernate hibernateContext;

    @Inject
    public GenderRepository() {}

    @Override
    public void insertGendersBatch(List<Gender> batch) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Gender> readGenders() {
        List<Gender> genders = null;
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            genders = session.createQuery("from Gender", Gender.class).list();
            session.getTransaction().commit();
        }
        return genders;
    }

    @Override
    public void insertGender(Gender gender) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public Gender getGenderByName(String name) {
        Gender dbGender = null;
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();

            String hsql = "from Gender where name= :name";
            Query query = session.createQuery(hsql);
            query.setParameter("name", name);
            dbGender = (Gender) query.uniqueResult();

            session.getTransaction().commit();
        }
        return dbGender;
    }
}
