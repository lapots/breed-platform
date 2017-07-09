package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.HibernateContext;
import com.lapots.breed.platform.core.repository.domain.NPCharacter;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class NpcRepository implements INpcRepository {
    @Override
    public void insertNpcBatch(List<NPCharacter> npcs) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            npcs.forEach(session::save);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<NPCharacter> readNpcs() {
        List<NPCharacter> npcs = null;
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            npcs = session.createQuery("from NPCharacter", NPCharacter.class).list();
            session.getTransaction().commit();
        }
        return null == npcs ? Collections.emptyList() : npcs;
    }

    @Override
    public void insertNpc(NPCharacter npc) {
        try (Session session = HibernateContext.INSTANCE.getSession()) {
            session.beginTransaction();
            session.save(npc);
            session.getTransaction().commit();
        }
    }
}
