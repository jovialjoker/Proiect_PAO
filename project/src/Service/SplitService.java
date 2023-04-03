package Service;

import Model.Enums.Muscle_Groups;
import Repository.ExerciseRepository;
import Repository.SplitRepository;
import Repository.WorkoutRepository;

import java.util.Arrays;
import java.util.List;

public class SplitService implements ISplitService{
    private ExerciseRepository exerciseRepository;
    private WorkoutRepository workoutRepository;
    private SplitRepository splitRepository;

    public SplitService(){
        exerciseRepository = new ExerciseRepository();
        workoutRepository = new WorkoutRepository();
        splitRepository = new SplitRepository();
    }

}
