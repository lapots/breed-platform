package com.lapots.breed.platform.json;

import com.lapots.breed.platform.core.repository.domain.MainFemaleCharacter;
import com.lapots.breed.platform.core.repository.domain.NPCharacter;
import com.lapots.breed.platform.core.repository.domain.Race;
import com.owlike.genson.Genson;
import com.owlike.genson.stream.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class JsonDataProcessor {
    private static final String FILE = "/breed/data.json";

    @SuppressWarnings("unchecked")
    public static <T> List<T> readJsonList(String listName) {
        Genson genson = JsonContext.PARSER.getParser();
        List<T> result = null;
        try (InputStream is = JsonDataProcessor.class.getResourceAsStream(FILE)) {
            ObjectReader reader = genson.createReader(is);
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("races".equals(listName) && "races".equals(reader.name())) {
                    result = (List<T>) processRaceData(reader);
                    break;
                }

                if ("npc".equals(listName) && "npc".equals(reader.name())) {
                    result = (List<T>) processNpcData(reader);
                    break;
                }

                if ("mainCharacters".equals(listName) && "npc".equals(reader.name())) {
                    result = (List<T>) processMainCharactersData(reader);
                    break;
                }
                reader.skipValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static List<Race> processRaceData(ObjectReader reader) {
        List<Race> raceList = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            Race race = new Race();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("name".equals(reader.name())) { race.setName(reader.valueAsString()); }
                else { reader.skipValue(); }
            }
            reader.endObject();
            raceList.add(race);
        }
        reader.endArray();
        return raceList;
    }

    private static List<NPCharacter> processNpcData(ObjectReader reader) {
        List<NPCharacter> npcs = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            NPCharacter npc = new NPCharacter();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("race".equals(reader.name())) { npc.setRace(Race.valueOf(reader.valueAsString())); }
                else if ("age".equals(reader.name())) { npc.setAge(reader.valueAsInt()); }
                else if ("name".equals(reader.name())) { npc.setName(reader.valueAsString()); }
                else { reader.skipValue(); }

            }
            reader.endObject();
        }
        reader.endArray();
        return npcs;
    }

    private static List<MainFemaleCharacter> processMainCharactersData(ObjectReader reader) {
        List<MainFemaleCharacter> mainCharacters = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            MainFemaleCharacter fc = new MainFemaleCharacter();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("race".equals(reader.name())) { fc.setRace(Race.valueOf(reader.valueAsString())); }
                else if ("age".equals(reader.name())) { fc.setAge(reader.valueAsInt()); }
                else if ("name".equals(reader.name())) { fc.setName(reader.valueAsString()); }
                else if ("id".equals(reader.name())) { fc.setId(UUID.fromString(reader.valueAsString())); }
                else { reader.skipValue(); }

            }
            reader.endObject();
        }
        reader.endArray();
        return mainCharacters;
    }
}
