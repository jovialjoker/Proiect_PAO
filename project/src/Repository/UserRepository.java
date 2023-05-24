package Repository;

import DB.ProjectContext;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserRepository implements IRepository<User> {
    List<User> userList = new ArrayList<User>();
    static Connection context = ProjectContext.getConnection();

    @Override
    public void add(User object) throws SQLException {
        String query = "insert into project.user(id, name, age) values (?,?,?)";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, UUID.randomUUID().toString());
        statement.setString(2, object.getName());
        statement.setString(3, String.valueOf(object.getAge()));
        statement.executeUpdate();
    }

    @Override
    public User get(UUID id) throws SQLException {
        String query = "select * from project.user where id = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        try {
            while (resultSet.next()) {
                user = setUser(resultSet);
            }
        } catch (Exception e) {
            //do stuff;
        }
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        String query = "select * from project.user";
        PreparedStatement statement = context.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            userList.add(setUser(resultSet));
        }

        return userList;
    }

    @Override
    public void delete(UUID id) throws SQLException {
        String query = "delete from project.user where id = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        statement.executeUpdate();
    }

    private User setUser(ResultSet resultSet) throws SQLException {
        return new User(UUID.fromString(resultSet.getString("id")), resultSet.getString("name"), resultSet.getInt("age"));
    }
}
