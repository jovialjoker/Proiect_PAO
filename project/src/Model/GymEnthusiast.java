package Model;

import java.util.*;

public class GymEnthusiast extends User{
    private List<Split> splitList;

    public GymEnthusiast(){
        splitList = new ArrayList<Split>();
    }

    public GymEnthusiast(List<Split> splitList){
        this.splitList = splitList;
    }


}
