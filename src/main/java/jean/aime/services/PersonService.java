package jean.aime.services;

import jean.aime.entities.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person findById(Long id);

    List<Person> fetchAll();
}
