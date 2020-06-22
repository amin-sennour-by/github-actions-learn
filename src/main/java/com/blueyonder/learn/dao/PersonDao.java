package com.blueyonder.learn.dao;

import com.blueyonder.learn.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Define the required access for a "person" database
 */
public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        return insertPerson(UUID.randomUUID(), person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}