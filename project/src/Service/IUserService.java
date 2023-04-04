package Service;

import Model.User;
import java.util.*;

public interface IUserService {
    public void AddUser(User newUser);
    public User GetUser(UUID id);
    public List<User> GetUsers();
}
