package com.lapots.breed.platform.core.repository;

import com.lapots.breed.platform.core.MainFemaleCharacter;
import com.lapots.breed.platform.core.repository.api.IMainFemaleCharacterRepository;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class MainFemaleCharacterRepository implements IMainFemaleCharacterRepository {
    private static final String PLAYERS = "from player_characters";

    @Override
    public List<MainFemaleCharacter> listCharacters() {
        List<MainFemaleCharacter> characters;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            characters = session.createQuery(PLAYERS, MainFemaleCharacter.class).list();
        }
        return characters == null ? Collections.emptyList() : characters;
    }

    @Override
    public void saveCharacter(MainFemaleCharacter character) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            session.persist(character);
            session.getTransaction().commit();
        }
    }
}
