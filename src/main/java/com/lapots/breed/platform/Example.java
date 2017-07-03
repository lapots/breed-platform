package com.lapots.breed.platform;

import com.lapots.breed.platform.core.MainFemaleCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Example {

    private static final String PLAYERS = "from player_parameters";

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<MainFemaleCharacter> femaleCharacters = session.createQuery(PLAYERS,
                    MainFemaleCharacter.class).list();
            System.out.println("List of female characters: " + femaleCharacters);

            session.getTransaction().commit();
            session.close();
        } catch(Exception exc) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
