package com.blueyonder.learn.dao;

import com.blueyonder.learn.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(!personMaybe.isPresent()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int indexOfPersonToDelete = DB.indexOf(p);
            if(indexOfPersonToDelete >= 0){
                Person toPut = new Person(id, person.getName());
                DB.set(indexOfPersonToDelete, toPut);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}