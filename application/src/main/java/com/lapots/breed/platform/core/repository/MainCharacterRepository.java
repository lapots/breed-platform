package com.lapots.breed.platform.core.repository;

import com.lapots.breed.platform.core.domain.MainCharacter;
import com.lapots.breed.platform.core.repository.api.IMainCharacterRepository;
import org.hibernate.Session;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class MainCharacterRepository implements IMainCharacterRepository {

    @Override
    public void insertCharacterBatch(List<MainCharacter> batch) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            batch.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<MainCharacter> readCharacters() {
        List<MainCharacter> femaleCharacters = null;
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            femaleCharacters = session.createQuery("from MainCharacter", MainCharacter.class).list();
            session.getTransaction().commit();
        }
        return femaleCharacters;
    }

    @Override
    public void insertCharacter(MainCharacter character) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            session.save(character);
            session.getTransaction().commit();
        }
    }

    @Override
    public MainCharacter getCharacter(String id) {
        MainCharacter character = null;
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            character = session.get(MainCharacter.class, id);
            session.getTransaction().commit();
        }
        return character;
    }

    @Override
    public void insertBatch(List batch) {
        batch.forEach(object -> insertCharacter((MainCharacter) object));
    }
}
