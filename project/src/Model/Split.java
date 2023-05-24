package Model;

import java.util.*;

public class Split implements IEntity{
    private UUID idSplit;
    private String name;
    private TreeMap<Integer, Workout> workouts;
    public Split() {
        this.idSplit = UUID.randomUUID();
        this.workouts = new TreeMap<>();
    }

    public Split(UUID idSplit, String name) {
        this.idSplit = idSplit;
        this.name = name;

    }

    public UUID getIdSplit() {
        return idSplit;
    }

    public void setIdSplit(UUID idSplit) {
        this.idSplit = idSplit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<Integer, Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(TreeMap<Integer, Workout> workouts) {
        this.workouts = workouts;
    }
}
