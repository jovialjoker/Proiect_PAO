package Service;

import Model.Exercise;
import Model.Split;
import Model.Workout;

import java.util.List;
import java.util.UUID;

public interface ISplitService {
    public void AddExercise(Exercise newExercise);
    public void AddWorkout(Workout newWorkout);
    public void AddSplit(Split newSplit);

    public Exercise GetExercise(UUID id);
    public Workout GetWorkout(UUID id);
    public Split GetSplit(UUID id);

    public List<Exercise> GetExercises();
    public List<Workout> GetWorkouts();
    public List<Split> GetSplits();
}
