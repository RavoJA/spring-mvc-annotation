package jean.aime.repositories.base;

import java.util.List;


public interface BaseRepository<T, ID> {

    T createOrUpdate(T entity);

    T fetchOneById(ID id);

    List<T> fetchAll();

    void deleteById(ID id);
}
