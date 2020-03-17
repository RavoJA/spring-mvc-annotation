package jean.aime.repositories;


import jean.aime.entities.Person;
import jean.aime.repositories.base.BaseRepository;

import java.util.List;

public interface PersonRepository extends BaseRepository<Person, Long> {
    List<Person> testMeth();
}
