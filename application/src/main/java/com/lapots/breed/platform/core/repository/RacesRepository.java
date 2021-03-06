package com.lapots.breed.platform.core.repository;

import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.core.repository.api.IRacesRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class RacesRepository implements IRacesRepository {

    @Override
    public void insertRacesBatch(List<Race> batch) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Race> readRaces() {
        List<Race> races = null;
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            races = session.createQuery("from Race", Race.class).list();
            session.getTransaction().commit();
        }
        return null == races ? Collections.emptyList() : races;
    }

    @Override
    public void insertRace(Race race) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            session.save(race);
            session.getTransaction().commit();
        }
    }

    @Override
    public Race getRaceByName(String name) {
        Race dbRace = null;
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();

            String hsql = "from Race where name= :name";
            Query query = session.createQuery(hsql);
            query.setParameter("name", name);
            dbRace = (Race) query.uniqueResult();

            session.getTransaction().commit();
        }
        return dbRace;
    }

    @Override
    public void insertBatch(List batch) {
        batch.forEach(object -> insertRace((Race) object));
    }
}
