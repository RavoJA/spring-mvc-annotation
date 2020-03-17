package jean.aime.services;

import jean.aime.entities.Person;
import jean.aime.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.createOrUpdate(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.fetchOneById(id);
    }

    @Override
    public List<Person> fetchAll() {
        return personRepository.fetchAll();
    }
}
