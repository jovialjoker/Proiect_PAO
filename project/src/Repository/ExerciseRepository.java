package Repository;

import DB.ProjectContext;
import Model.Bodybuilding_Exercise;
import Model.Cardio_Exercise;
import Model.Enums.ExerciseTypes;
import Model.Enums.Muscle_Groups;
import Model.Exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class ExerciseRepository implements IRepository<Exercise> {

    static Connection context = ProjectContext.getConnection();


    @Override
    public void add(Exercise exercise) throws SQLException {
        String query = "insert into project.exercise(id, name, description, exercisetype, time, distance, repsNo, weight, targetedMuscleGroup) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = context.prepareStatement(query);
        String id = UUID.randomUUID().toString();
        statement.setString(1, id);
        statement.setString(2, exercise.getName());
        statement.setString(3, exercise.getDescr());

        if (exercise.getClass() == Bodybuilding_Exercise.class) {
            statement.setString(4, "1");
            statement.setString(5, null);
            statement.setString(6, null);
            statement.setString(7, String.valueOf(((Bodybuilding_Exercise) exercise).getRepsNo()));
            statement.setString(8, String.valueOf(((Bodybuilding_Exercise) exercise).getWeight()));

        } else if (exercise.getClass() == Cardio_Exercise.class) {
            statement.setString(4, "2");
            statement.setString(5, String.valueOf(((Cardio_Exercise) exercise).getTime()));
            statement.setString(6, String.valueOf(((Cardio_Exercise) exercise).getDistance()));
            statement.setString(7, null);
            statement.setString(8, null);
        }

        statement.setString(9, String.valueOf(exercise.getMuscleGroups().getLabel()));

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Exercise get(UUID id) throws SQLException {
        String query = "select * from project.exercise where id = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.setString(1, id.toString());

        ResultSet resultSet = statement.executeQuery();
        Exercise ex = new Exercise();
        try {
            while (resultSet.next()) {
                ex = setExercise(resultSet);
            }
        } catch (Exception e) {
            int c = 1;
        }
        return ex;
    }

    @Override
    public List<Exercise> getAll() throws SQLException {
        String query = "select * from project.exercise";
        PreparedStatement statement = context.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Exercise> exerciseList = new ArrayList<Exercise>();

        while (resultSet.next()) {
            Exercise exercise = new Exercise();
            exercise = setExercise(resultSet);
            exerciseList.add(exercise);
        }

        return exerciseList;
    }

    @Override
    public void delete(UUID id) throws SQLException {
        String query = "delete from project.exercise where id = ?";
        PreparedStatement statement = context.prepareStatement(query);
        statement.executeUpdate();
    }

    private Exercise setExercise(ResultSet resultSet) throws SQLException {
        Exercise ex = new Exercise(UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name"),
                resultSet.getString("description")
        );
        int type = resultSet.getInt("exercisetype");

        if (type == ExerciseTypes.BodyBuilding.getLabel()) {
            Bodybuilding_Exercise bodybuildingExercise = new Bodybuilding_Exercise(ex);
            resultSet.getFloat("distance");
            resultSet.getFloat("time");
            bodybuildingExercise.setRepsNo(resultSet.getInt("repsNo"));
            bodybuildingExercise.setWeight(resultSet.getInt("weight"));
            Muscle_Groups mg = Arrays.stream(Muscle_Groups.values()).filter(e -> {
                try {
                    return e.getLabel() == resultSet.getInt("targetedMuscleGroup");
                } catch (SQLException ee) {
                    throw new RuntimeException(ee);
                }
            }).findFirst().get();
            bodybuildingExercise.setMuscleGroup(mg);
            return bodybuildingExercise;
        } else {
            Cardio_Exercise cardioExercise = new Cardio_Exercise(ex);
            cardioExercise.setDistance(resultSet.getFloat("distance"));
            cardioExercise.setTime(resultSet.getFloat("time"));
            resultSet.getInt("repsNo");
            resultSet.getInt("weight");
            Muscle_Groups mg = Arrays.stream(Muscle_Groups.values()).filter(e -> {
                try {
                    return e.getLabel() == resultSet.getInt("targetedMuscleGroup");
                } catch (SQLException ee) {
                    throw new RuntimeException(ee);
                }
            }).findFirst().get();
            cardioExercise.setMuscleGroup(mg);
            return cardioExercise;
        }
    }
}
