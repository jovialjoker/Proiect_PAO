package Service;

import Model.Exercise;
import Model.Split;
import Model.Workout;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ISplitService {
    public void AddExercise(Exercise newExercise) throws SQLException;
    public void AddWorkout(Workout newWorkout) throws SQLException;
    public void AddSplit(Split newSplit) throws SQLException;

    public Exercise GetExercise(UUID id) throws SQLException;
    public Workout GetWorkout(UUID id) throws SQLException;
    public Split GetSplit(UUID id) throws SQLException;

    public List<Exercise> GetExercises() throws SQLException;
    public List<Workout> GetWorkouts() throws SQLException;
    public List<Split> GetSplits() throws SQLException;
}
