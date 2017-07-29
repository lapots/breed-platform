package com.lapots.breed.platform.core.util.json;

import com.lapots.breed.platform.core.domain.Gender;
import com.lapots.breed.platform.core.domain.MainCharacter;
import com.lapots.breed.platform.core.domain.NPCharacter;
import com.lapots.breed.platform.core.domain.Race;
import com.lapots.breed.platform.core.repository.GenderRepository;
import com.lapots.breed.platform.core.repository.RacesRepository;
import com.owlike.genson.Genson;
import com.owlike.genson.stream.ObjectReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class JsonDataProcessor  {
    private static final String FILE = "/breed/data.json";

    private static RacesRepository racesRepository = new RacesRepository();
    private static GenderRepository genderRepository = new GenderRepository();

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
                } else if ("npc".equals(listName) && "npc".equals(reader.name())) {
                    result = (List<T>) processNpcData(reader);
                    break;
                } else if ("mainCharacters".equals(listName) && "mainCharacters".equals(reader.name())) {
                    result = (List<T>) processMainCharactersData(reader);
                    break;
                } else if ("genders".equals(listName) && "genders".equals(reader.name())) {
                    result = (List<T>) processGenderData(reader);
                    break;
                } else { reader.skipValue(); }

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

                if ("race".equals(reader.name())) {
                    npc.setRace(racesRepository.getRaceByName(reader.valueAsString()));
                } else if ("age".equals(reader.name())) {
                    npc.setAge(reader.valueAsInt());
                } else if ("name".equals(reader.name())) {
                    npc.setName(reader.valueAsString());
                } else if ("gender".equals(reader.name())) {
                    npc.setGender(genderRepository.getGenderByName(reader.valueAsString()));
                }
                else { reader.skipValue(); }

            }
            reader.endObject();
            npcs.add(npc);
        }
        reader.endArray();
        return npcs;
    }

    private static List<MainCharacter> processMainCharactersData(ObjectReader reader) {
        List<MainCharacter> mainCharacters = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            MainCharacter fc = new MainCharacter();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("race".equals(reader.name())) {
                    fc.setRace(racesRepository.getRaceByName(reader.valueAsString()));
                } else if ("age".equals(reader.name())) {
                    fc.setAge(reader.valueAsInt());
                } else if ("name".equals(reader.name())) {
                    fc.setName(reader.valueAsString());
                } else if ("gender".equals(reader.name())) {
                    fc.setGender(genderRepository.getGenderByName(reader.valueAsString()));
                } else {
                    reader.skipValue();
                }

            }
            reader.endObject();
            mainCharacters.add(fc);
        }
        reader.endArray();
        return mainCharacters;
    }

    private static List<Gender> processGenderData(ObjectReader reader) {
        List<Gender> genderList = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            reader.next();

            Gender gender = new Gender();
            reader.beginObject();
            while (reader.hasNext()) {
                reader.next();

                if ("name".equals(reader.name())) { gender.setName(reader.valueAsString()); }
                else { reader.skipValue(); }
            }
            reader.endObject();
            genderList.add(gender);
        }
        reader.endArray();
        return genderList;
    }
}
