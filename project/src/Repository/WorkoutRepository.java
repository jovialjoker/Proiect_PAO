package Repository;

import DB.ProjectContext;
import Model.Exercise;
import Model.Workout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class WorkoutRepository implements IRepository<Workout> {
    List<Workout> workoutList = new ArrayList<Workout>();
    ExerciseRepository _repo;

    public WorkoutRepository(ExerciseRepository repo) {
        _repo = repo;
    }

    static Connection context = ProjectContext.getConnection();

    @Override
    public void add(Workout workout) throws SQLException {
        String query = "insert into project.workout(idworkout, name) value (?,?);";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, workout.getIdWorkout().toString());
        statement.setString(2, workout.getName());
        statement.executeUpdate();

        for (Exercise e : workout.getExercises()) {
            query = "insert into project.exerciseworkout(idexercise, idworkout) values (?, ?);";
            statement = context.prepareStatement(query);
            statement.setString(1, e.getId().toString());
            statement.setString(2, workout.getIdWorkout().toString());
            statement.executeUpdate();
        }
    }

    @Override
    public Workout get(UUID id) throws SQLException {
        String query = "select * from project.exerciseworkout where idworkout = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        ResultSet resultSet = statement.executeQuery();
        List<Exercise> exerciseList = new ArrayList<Exercise>();
        while (resultSet.next()) {
            Exercise ex = _repo.get(UUID.fromString(resultSet.getString("idexercise")));
            exerciseList.add(ex);
        }

        query = "select * from project.workout where idworkout = ?";
        statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        resultSet = statement.executeQuery();
        Workout workout = new Workout();
        try {
            while (resultSet.next()) {
                workout = setWorkout(resultSet);
            }
        } catch (Exception e) {
            //do stuff;
        }

        workout.setExercises(exerciseList);

        return workout;

    }

    @Override
    public List<Workout> getAll() throws SQLException {
        String query = "select * from project.workout";
        PreparedStatement statement = context.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<UUID> idList = new ArrayList<UUID>();

        while (resultSet.next()) {
            idList.add(UUID.fromString(resultSet.getString("idworkout")));
        }
        List<Workout> workoutList = new ArrayList<Workout>();

        for (UUID id : idList) {
            workoutList.add(this.get(id));
        }
        return workoutList;
    }

    @Override
    public void delete(UUID id) throws SQLException {
        String query = "delete from project.workout where idworkout = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());
        statement.executeUpdate();
    }

    private Workout setWorkout(ResultSet resultSet) throws SQLException {
        return new Workout(UUID.fromString(resultSet.getString("idworkout")), resultSet.getString("name"));
    }
}
