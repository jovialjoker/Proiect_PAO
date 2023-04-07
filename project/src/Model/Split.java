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

    public Split(UUID idSplit, String name, List<Workout> workouts) {
        this.idSplit = idSplit;
        this.name = name;
        int i = new Integer("0");
        for(Workout workout: workouts){
            this.workouts.put(i, workout);
            i++;
        }
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
