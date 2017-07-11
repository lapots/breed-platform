package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter;
import org.hibernate.Session;

import java.util.List;

public class MainCharacterRepository implements IMainCharacterRepository {
    @Override
    public void insertCharacterBatch(List<MainFemaleCharacter> batch) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<MainFemaleCharacter> readCharacters() {
        List<MainFemaleCharacter> femaleCharacters = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            femaleCharacters = session.createQuery("from MainFemaleCharacter", MainFemaleCharacter.class).list();
            session.getTransaction().commit();
        }
        return femaleCharacters;
    }

    @Override
    public void insertCharacter(MainFemaleCharacter character) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            session.save(character);
            session.getTransaction().commit();
        }
    }

    @Override
    public MainFemaleCharacter getCharacter(String id) {
        MainFemaleCharacter character = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            character = session.get(MainFemaleCharacter.class, id);
            session.getTransaction().commit();
        }
        return character;
    }
}
