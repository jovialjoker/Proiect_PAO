package Model;

import java.util.*;

public class Exercise implements IEntity {
    private UUID id;
    private String name;
    private String descr;
    private List<Muscle_Group> muscleGroupList;

    public Exercise() {
        this.id = UUID.randomUUID();
        this.muscleGroupList = new ArrayList<Muscle_Group>();
    }

    public Exercise(UUID id, String name, String descr, List<Muscle_Group> muscleGroupList) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.muscleGroupList = muscleGroupList;
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
}
