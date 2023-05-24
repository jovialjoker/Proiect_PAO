package Service;

import Model.User;

import java.sql.SQLException;
import java.util.*;

public interface IUserService {
    public void AddUser(User newUser) throws SQLException;
    public User GetUser(UUID id) throws SQLException ;
    public List<User> GetUsers() throws SQLException;
}
