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

    public void AddWorkout(Workout newWorkout) throws SQLException {
        _service.AddWorkout(newWorkout);
    }

    public void AddSplit(Split newSplit) throws SQLException {
        _service.AddSplit(newSplit);
    }

    public Exercise GetExercise(UUID id) throws SQLException {
        return _service.GetExercise(id);
    }

    public Workout GetWorkout(UUID id) throws SQLException {
        return _service.GetWorkout(id);
    }

    public Split GetSplit(UUID id) throws SQLException {
        return _service.GetSplit(id);
    }

    public List<Exercise> GetExercises() throws SQLException {
        return _service.GetExercises();
    }

    public List<Workout> GetWorkouts() throws SQLException {
        return _service.GetWorkouts();
    }

    public List<Split> GetSplits() throws SQLException {
        return _service.GetSplits();
    }
}
