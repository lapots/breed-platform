package com.lapots.breed.platform.core.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Hibernate {
    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    @Inject
    public Hibernate() {
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    @PreDestroy
    public void stopHibernate() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
