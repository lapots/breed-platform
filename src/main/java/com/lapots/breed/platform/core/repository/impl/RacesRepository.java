package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.Race;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class RacesRepository implements IRacesRepository {
    @Override
    public void insertRacesBatch(List<Race> batch) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Race> readRaces() {
        List<Race> races = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            races = session.createQuery("from Race", Race.class).list();
            session.getTransaction().commit();
        }
        return races == null ? Collections.emptyList() : races;
    }

    @Override
    public void insertRace(Race race) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            session.save(race);
            session.getTransaction().commit();
        }
    }
}
