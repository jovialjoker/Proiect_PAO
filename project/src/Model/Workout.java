package Model;

import Model.Exercise;

import java.util.*;
import java.util.UUID;

public class Workout implements IEntity {
    private UUID idWorkout;
    private String name;
    private List<Exercise> exercises;

    public Workout() {
        this.idWorkout = UUID.randomUUID();
        this.exercises = new ArrayList<>();
    }

    public Workout(UUID idWorkout, String name, List<Exercise> exercises) {
        this.idWorkout = idWorkout;
        this.name = name;
        this.exercises = exercises;
    }

    public UUID getIdWorkout() {
        return idWorkout;
    }

    public void setIdWorkout(UUID idWorkout) {
        this.idWorkout = idWorkout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
