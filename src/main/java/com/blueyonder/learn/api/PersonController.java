package com.blueyonder.learn.api;

import com.blueyonder.learn.model.Person;
import com.blueyonder.learn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v2/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired // same as before, the PersonService will get injected
    public PersonController(PersonService s){
        personService = s;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull  @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping(path = "/{id}")
    public void putPersonById(@PathVariable UUID id, @Valid @NonNull @RequestBody Person person){
        personService.updatePersonById(id, person);
    }
}
