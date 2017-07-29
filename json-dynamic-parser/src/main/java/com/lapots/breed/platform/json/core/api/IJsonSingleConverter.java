package com.lapots.breed.platform.json.core.api;

/**
 * Converts simple elements. For example
 *
 *    "race": "HUMAN"
 *
 *  if there is
 *
 *      class Race {
 *          string name;
 *      }
 *
 *      class Person {
 *          Race race; // will create object with HUMAN
 *      }
 * @param <FROM>
 * @param <TO>
 */
public interface IJsonSingleConverter<FROM, TO> {
    TO convert(FROM object);
}
