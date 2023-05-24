package Service;

import Model.User;
import Repository.UnitOfWork;
import Repository.UserRepository;

import java.sql.SQLException;
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
    public void AddUser(User newUser) throws SQLException {
        uow.userRepository.add(newUser);
    }

    @Override
    public User GetUser(UUID id) throws SQLException {
        return uow.userRepository.get(id);
    }

    @Override
    public List<User> GetUsers() throws SQLException{
        return uow.userRepository.getAll();
    }

}
