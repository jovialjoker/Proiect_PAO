package Service;

import Repository.UserRepository;

public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService(){
        this.userRepository = new UserRepository();
    }
}
