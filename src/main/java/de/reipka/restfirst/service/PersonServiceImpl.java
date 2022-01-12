package de.reipka.restfirst.service;

import de.reipka.restfirst.model.Person;
import de.reipka.restfirst.repository.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

//    PersonRepo personRepo;

    @Override
    public boolean createPerson(PersonRepo personRepo,String firstName, String lastName, Integer age) {

        Person newPerson = new Person();
        newPerson.getPersonId();
        newPerson.setAge(age);
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        if(personRepo.save(newPerson) != null ) {
            return true;
        } else return false;
    }
}
