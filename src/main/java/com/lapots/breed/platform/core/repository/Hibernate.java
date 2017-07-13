package com.lapots.breed.platform.core.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public enum Hibernate {
    CONTEXT;

    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
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
