package de.reipka.restfirst.service;

import de.reipka.restfirst.repository.PersonRepo;

public interface PersonService {

    public boolean createPerson(PersonRepo personRepo, String firstName, String lastName, Integer age);

}
