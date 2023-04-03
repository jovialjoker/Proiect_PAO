package Model;

import java.util.List;
import java.util.UUID;
public class Cardio_Exercise extends Exercise{
    private float time;
    private float distance;

    public Cardio_Exercise() {
        super();
    }

    public Cardio_Exercise(UUID id, String nume, String descr, float time, float distance, List<Muscle_Group> muscleGroupList) {
        super(id, nume, descr, muscleGroupList);
        this.time = time;
        this.distance = distance;
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
