package Service;

import Model.Exercise;
import Model.Split;
import Model.Workout;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ISplitService {
    public void AddExercise(Exercise newExercise) throws SQLException;
    public void AddWorkout(Workout newWorkout);
    public void AddSplit(Split newSplit);

    public Exercise GetExercise(UUID id) throws SQLException;
    public Workout GetWorkout(UUID id);
    public Split GetSplit(UUID id);

    public List<Exercise> GetExercises() throws SQLException;
    public List<Workout> GetWorkouts();
    public List<Split> GetSplits();
}
