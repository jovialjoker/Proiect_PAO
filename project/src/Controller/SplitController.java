package Controller;

import Model.*;
import Service.SplitService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class SplitController {
    private SplitService _service;

    public SplitController(){
        _service = new SplitService();
    }

    public void AddExercise(Exercise newExercise) throws SQLException {
        _service.AddExercise(newExercise);
    }

    public void AddWorkout(Workout newWorkout) {
        _service.AddWorkout(newWorkout);
    }

    public void AddSplit(Split newSplit) {
        _service.AddSplit(newSplit);
    }

    public Exercise GetExercise(UUID id) throws SQLException {
        return _service.GetExercise(id);
    }

    public Workout GetWorkout(UUID id) {
        return _service.GetWorkout(id);
    }

    public Split GetSplit(UUID id) {
        return _service.GetSplit(id);
    }

    public List<Exercise> GetExercises() throws SQLException {
        return _service.GetExercises();
    }

    public List<Workout> GetWorkouts() {
        return _service.GetWorkouts();
    }

    public List<Split> GetSplits() {
        return _service.GetSplits();
    }
}
