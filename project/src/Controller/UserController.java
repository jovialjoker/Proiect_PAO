package Controller;

import Model.User;
import Service.UserService;

import java.util.List;
import java.util.UUID;

public class UserController {
    private UserService _service;

    public UserController(){
        _service = new UserService();
    }

    public void AddUser(User newUser){
        _service.AddUser(newUser);
    }

    public User GetUser(UUID id){
        return _service.GetUser(id);
    }

    public List<User> GetUsers(){
        return _service.GetUsers();
    }
}
