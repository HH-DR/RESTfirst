package de.reipka.restfirst.controller;

import de.reipka.restfirst.model.Person;
import de.reipka.restfirst.repository.PersonRepo;
import de.reipka.restfirst.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
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

        personService.createPerson(personRepo,firstName,lastName,age);

        return "/person/all";
    }

    @RequestMapping("/person/all")
    public String findAllPersons(){
        StringBuilder stringBuilder = new StringBuilder("");

        for(Person person : personRepo.findAll()){
            stringBuilder.append(person.getPersonId()+"\t");
            stringBuilder.append(person.getFirstName()+"\t");
            stringBuilder.append(person.getLastName()+"\t");
            stringBuilder.append(person.getAge()+"\t\n");
        }

       return "These are all persons:\n" + stringBuilder;
    }

}
