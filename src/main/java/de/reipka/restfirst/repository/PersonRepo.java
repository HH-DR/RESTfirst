package de.reipka.restfirst.repository;

import de.reipka.restfirst.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepo extends JpaRepository <Person, Long>{
    // JpaRepository provides methods like save, find, delete
    // Personrepo wird über constructor eingebunden und bereitgestellt
}
