package Model;

import Model.Enums.Muscle_Groups;

import java.util.List;
import java.util.UUID;

public class Bodybuilding_Exercise extends Exercise {
    private int repsNo;
    private int weight;

    public Bodybuilding_Exercise() {
        super();
    }

    public Bodybuilding_Exercise(UUID id, String nume, String descr, int repsNo, int weight, Muscle_Groups muscleGroupList) {
        super(id, nume, descr, muscleGroupList);
        this.repsNo = repsNo;
        this.weight = weight;
    }

    public Bodybuilding_Exercise(Exercise exercise){
        super(exercise.getId(), exercise.getName(), exercise.getDescr(), exercise.getMuscleGroups());
    }

    public int getRepsNo() {
        return repsNo;
    }

    public void setRepsNo(int repsNo) {
        this.repsNo = repsNo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
