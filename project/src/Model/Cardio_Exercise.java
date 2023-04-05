package Model;

import Model.Enums.Muscle_Groups;

import java.util.List;
import java.util.UUID;
public class Cardio_Exercise extends Exercise{
    private float time;
    private float distance;

    public Cardio_Exercise() {
        super();
    }

    public Cardio_Exercise(UUID id, String nume, String descr, float time, float distance, Muscle_Groups muscleGroupList) {
        super(id, nume, descr, muscleGroupList);
        this.time = time;
        this.distance = distance;
    }

    public Cardio_Exercise(Exercise exercise){
        super(exercise.getId(), exercise.getName(), exercise.getDescr(), exercise.getMuscleGroups());
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
