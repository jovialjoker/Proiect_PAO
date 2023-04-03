package Repository;

import Model.Workout;

import java.util.*;

public class WorkoutRepository implements IRepository<Workout>{
    List<Workout> workoutList = new ArrayList<Workout>();

    @Override
    public void add(Workout workout) {
        workoutList.add(workout);
    }

    @Override
    public Workout get(UUID id) {
        return workoutList.stream().filter(e -> e.getIdWorkout() == id).findAny().get();

    }

    @Override
    public List<Workout> getAll() {
        return workoutList;
    }

    @Override
    public void delete(UUID id) {
        workoutList.removeIf(e -> e.getIdWorkout() == id);
    }
}
