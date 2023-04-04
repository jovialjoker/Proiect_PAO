package Service;

import Model.Enums.Muscle_Groups;
import Model.Exercise;
import Model.Muscle_Group;
import Model.Split;
import Model.Workout;
import Repository.ExerciseRepository;
import Repository.Muscle_GroupRepository;
import Repository.SplitRepository;
import Repository.WorkoutRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SplitService implements ISplitService{
    private ExerciseRepository exerciseRepository;
    private WorkoutRepository workoutRepository;
    private SplitRepository splitRepository;
    private Muscle_GroupRepository muscleGroupRepository;

    public SplitService(){
        exerciseRepository = new ExerciseRepository();
        workoutRepository = new WorkoutRepository();
        splitRepository = new SplitRepository();
        muscleGroupRepository = new Muscle_GroupRepository();
        muscleGroupRepository.init();
    }


    @Override
    public void AddExercise(Exercise newExercise) {
        exerciseRepository.add(newExercise);
    }

    @Override
    public void AddWorkout(Workout newWorkout) {
        workoutRepository.add(newWorkout);
    }

    @Override
    public void AddSplit(Split newSplit) {
        splitRepository.add(newSplit);
    }

    @Override
    public Exercise GetExercise(UUID id) {
        return exerciseRepository.get(id);
    }

    @Override
    public Workout GetWorkout(UUID id) {
        return workoutRepository.get(id);
    }

    @Override
    public Split GetSplit(UUID id) {
        return splitRepository.get(id);
    }

    @Override
    public List<Exercise> GetExercises() {
        return exerciseRepository.getAll();
    }

    @Override
    public List<Workout> GetWorkouts() {
        return workoutRepository.getAll();
    }

    @Override
    public List<Split> GetSplits() {
        return splitRepository.getAll();
    }
}
