package jean.aime.repositories.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@Repository
public abstract class AbstractBaseRepositoryImpl<T, ID> implements BaseRepository<T, ID> {
    private static final Logger log = (Logger) LoggerFactory.getLogger(AbstractBaseRepositoryImpl.class);

    protected abstract Class<T> baseEntity();

    private final SessionFactory sessionFactory;

    protected AbstractBaseRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T createOrUpdate(T entity) {
        Assert.notNull(entity, "Entity cannot be null");
        session().save(entity);
        return entity;
    }

    public T fetchOneById(ID id) {
        Assert.notNull(id, "Identifier cannot be null");
        return session().find(baseEntity(), id);
    }

    @Override
    public List<T> fetchAll() {
        log.info("[ " + baseEntity().getName() + "] fetch all data ");
        String queryString = String.format("FROM %s", baseEntity().getName());
        Query query = session().createQuery(queryString, baseEntity());
        return query.getResultList();

    }

    @Override
    public void deleteById(ID id) {
        Assert.notNull(id, "Identifier cannot be null");
        session().delete(baseEntity().getName(), id);
        session().flush();
    }

}
