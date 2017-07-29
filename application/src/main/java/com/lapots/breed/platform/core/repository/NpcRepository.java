package com.lapots.breed.platform.core.repository;

import com.lapots.breed.platform.core.domain.NPCharacter;
import com.lapots.breed.platform.core.repository.api.INpcRepository;
import org.hibernate.Session;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class NpcRepository implements INpcRepository {

    @Override
    public void insertNpcBatch(List<NPCharacter> npcs) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            npcs.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<NPCharacter> readNpcs() {
        List<NPCharacter> npcs = null;
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            npcs = session.createQuery("from NPCharacter", NPCharacter.class).list();
            session.getTransaction().commit();
        }
        return null == npcs ? Collections.emptyList() : npcs;
    }

    @Override
    public void insertNpc(NPCharacter npc) {
        try (Session session = Hibernate.CONTEXT.getSession()) {
            session.beginTransaction();
            session.save(npc);
            session.getTransaction().commit();
        }
    }

    @Override
    public void insertBatch(List batch) {
        batch.forEach(object -> insertNpc((NPCharacter) object));
    }
}
