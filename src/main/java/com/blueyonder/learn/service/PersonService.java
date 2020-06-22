package com.blueyonder.learn.service;

import com.blueyonder.learn.dao.PersonDao;
import com.blueyonder.learn.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    /**
     * So this is the complex singleton pattern. You use the "@repo/@bean/@whatever" to
     * instantiate an object once, and then use this @Authowired tag to fill all params of that type
     * with that single instance
     *
     * The qualifers allow this to work with interfaces / concreat types. Basically, the "type / interface"
     * is auto injected, and then the qualifier tag picks which of the real classes should be filled
     *
     * Neat
     *
     * @param personDao the single instance of a personDao. Interesting
     */
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person){
        return personDao.updatePersonById(id, person);
    }
}

