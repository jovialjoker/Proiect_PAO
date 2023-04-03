package Model;

import java.util.*;

public class Split implements IEntity{
    private UUID idSplit;
    private String name;
    private List<Workout> workouts;
    public Split() {
        this.idSplit = UUID.randomUUID();
        this.workouts = new ArrayList<>();
    }

    public Split(UUID idSplit, String name, List<Workout> workouts) {
        this.idSplit = idSplit;
        this.name = name;
        this.workouts = workouts;
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

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
