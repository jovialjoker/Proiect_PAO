package Service;

import Model.Enums.Muscle_Groups;
import Model.Exercise;
import Model.Muscle_Group;
import Model.Split;
import Model.Workout;
import Repository.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SplitService implements ISplitService{
    private UnitOfWork uow;
//    private ExerciseRepository exerciseRepository;
//    private WorkoutRepository workoutRepository;
//    private SplitRepository splitRepository;
//    private Muscle_GroupRepository muscleGroupRepository;

    public SplitService(){
//        exerciseRepository = new ExerciseRepository();
//        workoutRepository = new WorkoutRepository();
//        splitRepository = new SplitRepository();
//        muscleGroupRepository = new Muscle_GroupRepository();
//        muscleGroupRepository.init();
        uow = UnitOfWork.getInstance();
    }


    @Override
    public void AddExercise(Exercise newExercise) throws SQLException {
        uow.exerciseRepository.add(newExercise);
    }

    @Override
    public void AddWorkout(Workout newWorkout) throws SQLException {
        uow.workoutRepository.add(newWorkout);
    }

    @Override
    public void AddSplit(Split newSplit) throws SQLException {
        uow.splitRepository.add(newSplit);
    }

    @Override
    public Exercise GetExercise(UUID id) throws SQLException {
        return uow.exerciseRepository.get(id);
    }

    @Override
    public Workout GetWorkout(UUID id) throws SQLException {
        return uow.workoutRepository.get(id);
    }

    @Override
    public Split GetSplit(UUID id) throws SQLException {
        return uow.splitRepository.get(id);
    }

    @Override
    public List<Exercise> GetExercises() throws SQLException {
        return uow.exerciseRepository.getAll();
    }

    @Override
    public List<Workout> GetWorkouts()throws SQLException {
        return uow.workoutRepository.getAll();
    }

    @Override
    public List<Split> GetSplits() throws SQLException{
        return uow.splitRepository.getAll();
    }
}
