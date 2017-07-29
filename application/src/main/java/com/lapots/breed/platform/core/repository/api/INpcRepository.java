package com.lapots.breed.platform.core.repository.api;

import com.lapots.breed.platform.core.domain.NPCharacter;
import com.lapots.breed.platform.json.core.api.IJsonProcessableRepository;

import java.util.List;

public interface INpcRepository extends IJsonProcessableRepository {
    void insertNpcBatch(List<NPCharacter> npcs);
    List<NPCharacter> readNpcs();
    void insertNpc(NPCharacter npc);
}
