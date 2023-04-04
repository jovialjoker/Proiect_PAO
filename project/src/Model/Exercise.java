package Model;

import Model.Enums.Muscle_Groups;

import java.util.*;

public class Exercise implements IEntity {
    private UUID id;
    private String name;
    private String descr;
    private Muscle_Groups muscleGroup;

    public Exercise() {
        this.id = UUID.randomUUID();
    }

    public Exercise(UUID id, String name, String descr, Muscle_Groups muscleGroup) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.muscleGroup = muscleGroup;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Muscle_Groups getMuscleGroup(){
        return this.muscleGroup;
    }

    public void setMuscleGroup(Muscle_Groups muscleGroup){
        this.muscleGroup = muscleGroup;
    }
}
