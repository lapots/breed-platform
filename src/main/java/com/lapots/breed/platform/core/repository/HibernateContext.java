package com.lapots.breed.platform.core.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum HibernateContext {
    INSTANCE;

    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    {
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

    public void closeHibernateContext() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
