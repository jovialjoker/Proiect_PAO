package Repository;

import Controller.SplitController;
import Controller.UserController;
import DB.ProjectContext;
import Model.CRUDMenu;

import java.sql.Connection;

public class UnitOfWork {
    static Connection context = ProjectContext.getConnection();
    private static UnitOfWork uow = null;

    public final ExerciseRepository exerciseRepository;
    public final SplitRepository splitRepository;
    public final Muscle_GroupRepository muscleGroupRepository;
    public final UserRepository userRepository;
    public final WorkoutRepository workoutRepository;

    private UnitOfWork()
    {
        exerciseRepository = new ExerciseRepository();
        splitRepository = new SplitRepository();
        muscleGroupRepository = new Muscle_GroupRepository();
        userRepository = new UserRepository();
        workoutRepository = new WorkoutRepository();
    }

    public static synchronized UnitOfWork getInstance()
    {
        if (uow == null)
            uow = new UnitOfWork();

        return uow;
    }
}
