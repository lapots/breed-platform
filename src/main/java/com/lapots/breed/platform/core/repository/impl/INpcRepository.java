package com.lapots.breed.platform.core.repository.impl;

import com.lapots.breed.platform.core.repository.domain.NPCharacter;

import java.util.List;

public interface INpcRepository {
    void insertNpcBatch(List<NPCharacter> npcs);
    List<NPCharacter> readNpcs();
    void insertNpc(NPCharacter npc);
}
