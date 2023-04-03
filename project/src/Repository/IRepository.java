package Repository;

import java.util.*;

public interface IRepository<T> {
    public void add(T object);
    public T get(UUID id);

    public List<T> getAll();
    public void delete(UUID id);
}
