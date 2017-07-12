package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.domain.MainCharacter;
import com.lapots.breed.platform.core.repository.impl.api.IMainCharacterRepository;
import org.hibernate.Session;

import javax.inject.Inject;
import java.util.List;

public class MainCharacterRepository implements IMainCharacterRepository {

    @Inject
    Hibernate hibernateContext;

    @Inject
    public MainCharacterRepository() {}

    @Override
    public void insertCharacterBatch(List<MainCharacter> batch) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<MainCharacter> readCharacters() {
        List<MainCharacter> femaleCharacters = null;
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            femaleCharacters = session.createQuery("from MainCharacter", MainCharacter.class).list();
            session.getTransaction().commit();
        }
        return femaleCharacters;
    }

    @Override
    public void insertCharacter(MainCharacter character) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            session.save(character);
            session.getTransaction().commit();
        }
    }

    @Override
    public MainCharacter getCharacter(String id) {
        MainCharacter character = null;
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            character = session.get(MainCharacter.class, id);
            session.getTransaction().commit();
        }
        return character;
    }
}
