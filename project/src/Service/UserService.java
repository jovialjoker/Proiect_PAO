package Service;

import Model.User;
import Repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }

    @Override
    public void AddUser(User newUser) {
        userRepository.add(newUser);
    }

    @Override
    public User GetUser(UUID id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> GetUsers() {
        return userRepository.getAll();
    }

}
