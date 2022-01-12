package de.reipka.restfirst.controller;

import de.reipka.restfirst.model.Person;
import de.reipka.restfirst.repository.PersonRepo;
import de.reipka.restfirst.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// @RestController // kann nur Text zurückgeben - nicht die Seite
public class PersonController {

    private final PersonRepo personRepo;
    private final PersonService personService;

    PersonController(PersonRepo personRepo, PersonService personService){
        this.personRepo = personRepo;
        this.personService = personService;
    }

    @RequestMapping("/person/add")
    public String addPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("age") Integer age){

        if(personService.createPerson(personRepo,firstName,lastName,age)){
            return "Person saved";
        } return "Could not save Person";
    }

    // return List<Person> as Json
    @RequestMapping("/person/all")
    public List<Person> findAllPersons(){

        List<Person> personlist = new ArrayList<>();
        for(Person person : personRepo.findAll()){
            personlist.add(person);
        }
       return personlist;
    }

    @GetMapping("/person/delete")
    public String deletePersonById(@RequestParam Long personId){

        if(personRepo.findById(personId).isPresent()){
            personRepo.deleteById(personId);
            return "Person deleted.";
        } else return "Could not delete Person";
    }



    // return all Persons as String
//    @RequestMapping("/person/all")
//    public String findAllPersons(){
//        StringBuilder stringBuilder = new StringBuilder("");
//
//        for(Person person : personRepo.findAll()){
//            stringBuilder.append(person.getPersonId());
//            stringBuilder.append(person.getFirstName());
//            stringBuilder.append(person.getLastName());
//            stringBuilder.append(person.getAge());
//        }
//
//       return "These are all persons:\n" + stringBuilder;
//    }



}
