package Repository;

import Model.Exercise;

import java.util.*;

public class ExerciseRepository implements IRepository<Exercise> {
    List<Exercise> exercises = new ArrayList<Exercise>();

    @Override
    public void add(Exercise exercise) {
        exercises.add(exercise);
    }

    @Override
    public Exercise get(UUID id) {
        return exercises.stream().filter(e -> e.getId() == id).findAny().get();
    }

    @Override
    public List<Exercise> getAll() {
        return exercises;
    }

    @Override
    public void delete(UUID id) {
        exercises.removeIf(e -> e.getId() == id);
    }
}
