package Service;

import Model.User;
import Repository.UnitOfWork;
import Repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserService implements IUserService{
    private UnitOfWork uow;
//    private UserRepository userRepository;

    public UserService(){
//        this.userRepository = new UserRepository();
            uow = UnitOfWork.getInstance();
    }

    @Override
    public void AddUser(User newUser) {
        uow.userRepository.add(newUser);
    }

    @Override
    public User GetUser(UUID id) {
        return uow.userRepository.get(id);
    }

    @Override
    public List<User> GetUsers() {
        return uow.userRepository.getAll();
    }

}
