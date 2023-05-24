package Repository;

import DB.ProjectContext;
import Model.Bodybuilding_Exercise;
import Model.Cardio_Exercise;
import Model.Enums.ExerciseTypes;
import Model.Enums.Muscle_Groups;
import Model.Exercise;
import Model.Muscle_Group;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Muscle_GroupRepository {
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

    public List<Muscle_Group> getAll() throws SQLException {
        String query = "select * from project.musclegroups";
        PreparedStatement statement = context.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();
        List<Muscle_Group> muscleGroups = new ArrayList<Muscle_Group>();

        while (resultSet.next()) {
            Muscle_Group mg = setMuscleGroup(resultSet);
            muscleGroups.add(mg);
        }

        return muscleGroups;
    }

    private Muscle_Group setMuscleGroup(ResultSet resultSet) throws SQLException {

        Muscle_Group mg = new Muscle_Group(resultSet.getInt("id"),
                resultSet.getString("name")
        );
        return mg;
    }

}
