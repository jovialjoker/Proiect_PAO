package Repository;

import DB.ProjectContext;
import Model.Muscle_Group;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Muscle_GroupRepository{
    List<Muscle_Group> muscleGroupList = new ArrayList<Muscle_Group>();

//    public void init(){
//        muscleGroupList.add(new Muscle_Group(1, "Chest"));
//        muscleGroupList.add(new Muscle_Group(2, "Back"));
//        muscleGroupList.add(new Muscle_Group(3, "Biceps"));
//        muscleGroupList.add(new Muscle_Group(4, "Triceps"));
//        muscleGroupList.add(new Muscle_Group(5, "Deltoid"));
//        muscleGroupList.add(new Muscle_Group(6, "Forearms"));
//        muscleGroupList.add(new Muscle_Group(7, "Abs"));
//        muscleGroupList.add(new Muscle_Group(8, "Quads"));
//        muscleGroupList.add(new Muscle_Group(9, "Hamstring"));
//        muscleGroupList.add(new Muscle_Group(10, "Calves"));
//        muscleGroupList.add(new Muscle_Group(11, "Glutes"));
//        muscleGroupList.add(new Muscle_Group(12, "Cardio"));
//    }

    static Connection context = ProjectContext.getConnection();

    public List<Muscle_Group> getAll() {
        return muscleGroupList;
    }

}
