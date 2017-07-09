package com.lapots.breed.platform;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.Race;
import com.lapots.breed.platform.core.util.GroovyEmbeddedRunner;
import org.hibernate.Session;

import java.util.List;

public class Example {

    public static void main(String[] args) {
        List<Race> fileRaces = GroovyEmbeddedRunner.generateRacesList();
        System.out.println("Loaded races: " + fileRaces);
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();

            List<Race> races = session.createQuery("from Race", Race.class).list();
            System.out.println("All available races: " + races);

            session.getTransaction().commit();
        }
        HibernateContext.INSTANCE.closeHibernateContext();
    }
}
