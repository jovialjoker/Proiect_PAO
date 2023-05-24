package Repository;

import DB.ProjectContext;
import Model.*;
import Service.SplitService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SplitRepository implements IRepository<Split> {
    List<Split> splitList = new ArrayList<Split>();
    private WorkoutRepository _repo;

    public SplitRepository(WorkoutRepository repo) {
        _repo = repo;
    }

    static Connection context = ProjectContext.getConnection();

    @Override
    public void add(Split split) throws SQLException {
        String query = "insert into project.split(idsplit, name) value (?,?);";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, split.getIdSplit().toString());
        statement.setString(2, split.getName());
        statement.executeUpdate();

        for (Workout w : split.getWorkouts().values()) {
            query = "insert into project.splitworkout(idworkout, idsplit) values (?, ?);";
            statement = context.prepareStatement(query);
            statement.setString(1, w.getIdWorkout().toString());
            statement.setString(2, split.getIdSplit().toString());
            statement.executeUpdate();
        }
    }

    @Override
    public Split get(UUID id) throws SQLException {
        String query = "select idworkout, idsplit from project.splitworkout where idsplit = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        ResultSet resultSet = statement.executeQuery();
        TreeMap<Integer, Workout> workouts = new TreeMap<>();
        int i = 0;
        while (resultSet.next()) {
            Workout workout = _repo.get(UUID.fromString(resultSet.getString("idworkout")));
            resultSet.getString("idsplit");
            workouts.put(i, workout);
            i++;
        }

        query = "select * from project.split where idsplit = ?";
        statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        resultSet = statement.executeQuery();
        Split split = new Split();
        try {
            while (resultSet.next()) {
                split = setSplit(resultSet);
            }
        } catch (Exception e) {
            //treat me
        }
        split.setWorkouts(workouts);

        return split;
    }

    @Override
    public List<Split> getAll() throws SQLException {
        String query = "select * from project.split";
        PreparedStatement statement = context.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<UUID> idList = new ArrayList<UUID>();

        while (resultSet.next()) {
            idList.add(UUID.fromString(resultSet.getString("idsplit")));
            resultSet.getString("name");
        }
        List<Split> splitList = new ArrayList<Split>();
        for (UUID id : idList) {
            splitList.add(this.get(id));
        }
        return splitList;
    }

    @Override
    public void delete(UUID id) throws SQLException {
        String query = "delete from project.split where idsplit = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        statement.executeUpdate();
    }

    private Split setSplit(ResultSet resultSet) throws SQLException {
        return new Split(UUID.fromString(resultSet.getString("idsplit")),
                resultSet.getString("name")
        );
    }
}
