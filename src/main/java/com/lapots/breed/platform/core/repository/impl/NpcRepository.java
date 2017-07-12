package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.Hibernate;
import com.lapots.breed.platform.core.repository.domain.NPCharacter;
import com.lapots.breed.platform.core.repository.impl.api.INpcRepository;
import org.hibernate.Session;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

public class NpcRepository implements INpcRepository {

    @Inject
    Hibernate hibernateContext;

    @Inject
    public NpcRepository() {}

    @Override
    public void insertNpcBatch(List<NPCharacter> npcs) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            npcs.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<NPCharacter> readNpcs() {
        List<NPCharacter> npcs = null;
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            npcs = session.createQuery("from NPCharacter", NPCharacter.class).list();
            session.getTransaction().commit();
        }
        return null == npcs ? Collections.emptyList() : npcs;
    }

    @Override
    public void insertNpc(NPCharacter npc) {
        try (Session session = hibernateContext.getSession()) {
            session.beginTransaction();
            session.save(npc);
            session.getTransaction().commit();
        }
    }
}
