package Controller;

import Service.UserService;

public class UserController {
    private UserService _service;

    public UserController(){
        _service = new UserService();
    }
}
