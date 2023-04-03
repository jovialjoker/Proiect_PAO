package Repository;

import Model.User;

import java.util.*;

public class UserRepository implements IRepository<User>{
    List<User> userList = new ArrayList<User>();

    @Override
    public void add(User object) {
        userList.add(object);
    }

    @Override
    public User get(UUID id) {
        return userList.stream().filter(u -> u.getId() == id).findAny().get();
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void delete(UUID id) {
        userList.removeIf(u -> u.getId() == id);
    }
}
