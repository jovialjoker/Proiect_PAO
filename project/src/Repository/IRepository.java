package Repository;

import java.sql.SQLException;
import java.util.*;

public interface IRepository<T> {
    public void add(T object) throws SQLException;
    public T get(UUID id) throws SQLException;

    public List<T> getAll() throws SQLException;
    public void delete(UUID id) throws SQLException;
}
