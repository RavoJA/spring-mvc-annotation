package jean.aime.repositories.Impl;

import jean.aime.entities.Person;
import jean.aime.repositories.base.AbstractBaseRepositoryImpl;
import jean.aime.repositories.PersonRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl extends AbstractBaseRepositoryImpl<Person, Long> implements PersonRepository {

    protected PersonRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Person> baseEntity() {
        return Person.class;
    }

    @Override
    public List<Person> testMeth() {
        return null;
    }
}
