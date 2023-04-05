import Controller.SplitController;
import Controller.UserController;
import Model.*;
import Model.Enums.Muscle_Groups;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SplitController _splitController = new SplitController();
        UserController _userController = new UserController();

        System.out.println("WORKOUT BUDDY");
        Scanner sc = new Scanner(System.in);
        String option;
        do {
            System.out.println("\nChoice option: \n \"1\": Create  \n \"2\": View");
            option = sc.nextLine();
            System.out.println("You inserted: " + option);

            if (Integer.parseInt(option) == 1) {
                do {
                    System.out.println("\nChoice option: \n \"1\": Add User \n \"2\": Add Split \n \"3\": Add Workout \n \"4\": Add Exercise");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);

                    if (option.equals("1")) {
                        User newUser = new User();
                        System.out.println("\nCreate your new user:\n");
                        System.out.println("\nName:\n");
                        newUser.setName(sc.nextLine());
                        System.out.println("\nAge:\n");
                        newUser.setAge(Integer.parseInt(sc.nextLine()));
                        _userController.AddUser(newUser);
                        System.out.println("\n New user created succesfully!");
                    } else {
                        switch (option) {
                            case "2" -> {
                                Split newSplit = new Split();
                                System.out.println("\nCreate your new split:\n");
                                System.out.println("\nName:");
                                newSplit.setName(sc.nextLine());
                                System.out.println("\nChoose the workouts:");
                                List<Workout> workoutList = _splitController.GetWorkouts();
                                if (workoutList.size() != 0) {
                                    do {
                                        int i = 1;
                                        for (Workout workout : workoutList) {
                                            System.out.println("\n" + i + ", " + workout.getName());
                                            List<Exercise> exerciseList = workout.getExercises();
                                            for(Exercise exercise: exerciseList){
                                                System.out.println("- "+ exercise.getName() + ": ");
                                                if (exercise.getClass() == Bodybuilding_Exercise.class) {
                                                    System.out.println("\t" + ((Bodybuilding_Exercise) exercise).getRepsNo() + " reps;");
                                                    System.out.println("\t" + ((Bodybuilding_Exercise) exercise).getWeight() + " kgs;");
                                                } else if (exercise.getClass() == Cardio_Exercise.class) {
                                                    System.out.println("\t" + ((Cardio_Exercise) exercise).getTime() + " mins;");
                                                    System.out.println("\t" + ((Cardio_Exercise) exercise).getDistance() + " kms;");
                                                }
                                            }
                                            i++;
                                        }

                                        option = sc.nextLine();
                                        try {
                                            int index = Integer.parseInt(option) - 1;
                                            Workout workout = _splitController.GetWorkout(workoutList.get(index).getIdWorkout());
                                            List<Workout> oldWorkouts = newSplit.getWorkouts();
                                            oldWorkouts.add(workout);
                                            newSplit.setWorkouts(oldWorkouts);
                                        } catch (Exception e) {

                                        }
                                        System.out.println("\n Do you want to continue adding workouts? [y/n]");
                                        option = sc.nextLine();
                                    } while (!option.equals("n"));

                                    _splitController.AddSplit(newSplit);
                                    System.out.println("\n New split created succesfully!");
                                } else {
                                    System.out.println("\n There are no workouts! Add a workout then come back!");
                                }
                                break;
                            }
                            case "3" -> {
                                Workout newWorkout = new Workout();
                                System.out.println("\nCreate your new Workout:\n");
                                System.out.println("\nName:");
                                newWorkout.setName(sc.nextLine());
                                System.out.println("\nChoose the exercise:");
                                List<Exercise> exerciseList = _splitController.GetExercises();
                                if (exerciseList.size() != 0) {
                                    do {
                                        int i = 1;
                                        for (Exercise exercise : exerciseList) {
                                            System.out.println("\n" + i + ". " + exercise.getName());
                                            if (exercise.getClass() == Bodybuilding_Exercise.class) {
                                                System.out.println("\t" + ((Bodybuilding_Exercise) exercise).getRepsNo() + " reps;");
                                                System.out.println("\t" + ((Bodybuilding_Exercise) exercise).getWeight() + " kgs;");
                                            } else if (exercise.getClass() == Cardio_Exercise.class) {
                                                System.out.println("\t" + ((Cardio_Exercise) exercise).getTime() + " mins;");
                                                System.out.println("\t" + ((Cardio_Exercise) exercise).getDistance() + " kms;");
                                            }
                                            i++;
                                        }

                                        option = sc.nextLine();
                                        try {
                                            int index = Integer.parseInt(option) - 1;
                                            Exercise ex = _splitController.GetExercise(exerciseList.get(index).getId());
                                            List<Exercise> oldExercises = newWorkout.getExercises();
                                            oldExercises.add(ex);
                                            newWorkout.setExercises(oldExercises);
                                        } catch (Exception e) {

                                        }
                                        System.out.println("\n Do you want to continue adding exercises? [y/n]");
                                        option = sc.nextLine();
                                    } while (!option.equals("n"));

                                    _splitController.AddWorkout(newWorkout);
                                    System.out.println("\n New workout created succesfully!");
                                } else {
                                    System.out.println("\n There are no exercises! Add a exercise then come back!");
                                }
                                break;
                            }
                            case "4" -> {
                                Exercise newExercise = new Exercise();
                                System.out.println("\nCreate your new Exercise:\n");
                                System.out.println("\nName:");
                                newExercise.setName(sc.nextLine());
                                System.out.println("\nDescription:");
                                newExercise.setDescr(sc.nextLine());

                                System.out.println("\n Choose the muscle group targeted:");
                                for (Muscle_Groups value : Muscle_Groups.values()) {
                                    System.out.println("\n" + value.getLabel() + ": " + value.name());
                                }
                                option = sc.nextLine();
                                try {
                                    int index = Integer.parseInt(option);
                                    Muscle_Groups mg = Arrays.stream(Muscle_Groups.values()).filter(e -> e.getLabel() == index).findFirst().get();
                                    newExercise.setMuscleGroup(mg);
                                } catch (Exception e) {

                                }

                                System.out.println("\n Choose the type of the exercise: \n 1. Cardio \n 2. Bodybuilding");

                                option = sc.nextLine();
                                try {
                                    int index = Integer.parseInt(option);
                                    if (index == 1) {
                                        Cardio_Exercise cardioExercise = new Cardio_Exercise(newExercise);
                                        System.out.println("\nTime:");
                                        cardioExercise.setTime(Integer.parseInt(sc.nextLine()));
                                        System.out.println("\nDistance:");
                                        cardioExercise.setDistance(Integer.parseInt(sc.nextLine()));
                                        _splitController.AddExercise(cardioExercise);
                                    } else if (index == 2) {
                                        Bodybuilding_Exercise bbEx = new Bodybuilding_Exercise(newExercise);
                                        System.out.println("\nWeight:");
                                        bbEx.setWeight(Integer.parseInt(sc.nextLine()));
                                        System.out.println("\nNo of reps:");
                                        bbEx.setRepsNo(Integer.parseInt(sc.nextLine()));
                                        _splitController.AddExercise(bbEx);
                                    }
                                } catch (Exception e) {

                                }

                                System.out.println("\n New exercise created succesfully!");
                                break;
                            }
                        }
                    }
                } while (!option.equals("back") && !option.equals("stop"));

            } else if (Integer.parseInt(option) == 2) {
                do {
                    System.out.println("\nChoice option: \n \"1\": View Users \n \"2\": View Splits \n \"3\": View Workouts \n \"4\": View Exercises");
                    option = sc.nextLine();
                    System.out.println("You inserted: " + option);
                    if (option.equals("1")) {
                        List<User> users = _userController.GetUsers();
                        if (users.size() != 0) {
                            do {
                                int i = 1;
                                for (User user : users) {
                                    System.out.println("\n " + i + ". " + user.getName());
                                    i++;
                                }
                                System.out.println("\n If you want to see more info about a user type the number associated with it");
                                option = sc.nextLine();
                                try {
                                    int index = Integer.parseInt(option) - 1;
                                    User user = _userController.GetUser(users.get(index).getId());
                                    System.out.println("\n Your user is: " + user.getName());
                                    System.out.println("\n Age: " + user.getAge());
                                } catch (Exception e) {

                                }
                            } while (!option.equals("stop") && !option.equals("back"));
                        } else {
                            System.out.println("\n There are no users! Create some users and come back!");
                        }
                    } else {
                        switch (option) {
                            case "2": {
                                List<Split> splits = _splitController.GetSplits();
                                if (splits.size() != 0) {
                                    do {
                                        int i = 1;
                                        for (Split split : splits) {
                                            System.out.println("\n " + i + ". " + split.getName());
                                            i++;
                                        }
                                        System.out.println("\n If you want to see more info about a split type the number associated with it");
                                        option = sc.nextLine();
                                        try {
                                            int index = Integer.parseInt(option) - 1;
                                            Split split = _splitController.GetSplit(splits.get(index).getIdSplit());
                                            System.out.println("\n Your split is: " + split.getName());
                                            System.out.println("\n The workouts included are: ");
                                            int j = 1;
                                            for (Workout workout: split.getWorkouts()) {
                                                System.out.println(j + workout.getName());

                                                for(Exercise exercise: workout.getExercises()){
                                                    System.out.println("\t-" + exercise.getName());
                                                    if (exercise.getClass() == Bodybuilding_Exercise.class) {
                                                        System.out.println("\t\t" + ((Bodybuilding_Exercise) exercise).getRepsNo() + " reps;");
                                                        System.out.println("\t\t" + ((Bodybuilding_Exercise) exercise).getWeight() + " kgs;");
                                                    } else if (exercise.getClass() == Cardio_Exercise.class) {
                                                        System.out.println("\t\t" + ((Cardio_Exercise) exercise).getTime() + " mins;");
                                                        System.out.println("\t\t" + ((Cardio_Exercise) exercise).getDistance() + " kms;");
                                                    }
                                                    j++;
                                                }
                                            }
                                        } catch (Exception e) {

                                        }
                                    } while (!option.equals("stop") && !option.equals("back"));
                                } else {
                                    System.out.println("\n There are no workouts! Create some workouts and come back!");
                                }
                                break;
                            }
                            case "3": {
                                List<Workout> workouts = _splitController.GetWorkouts();
                                if (workouts.size() != 0) {
                                    do {
                                        int i = 1;
                                        for (Workout workout : workouts) {
                                            System.out.println("\n " + i + ". " + workout.getName());
                                            i++;
                                        }
                                        System.out.println("\n If you want to see more info about a workout type the number associated with it");
                                        option = sc.nextLine();
                                        try {
                                            int index = Integer.parseInt(option) - 1;
                                            Workout workout = _splitController.GetWorkout(workouts.get(index).getIdWorkout());
                                            System.out.println("\n Your workout is: " + workout.getName());
                                            System.out.println("\n The exercises included are: ");
                                            for (Exercise exercise : workout.getExercises()) {
                                                System.out.println("\t " + exercise.getName());
                                            }
                                        } catch (Exception e) {

                                        }
                                    } while (!option.equals("stop") && !option.equals("back"));
                                } else {
                                    System.out.println("\n There are no workouts! Create some workouts and come back!");
                                }
                                break;
                            }
                            case "4": {
                                List<Exercise> exercises = _splitController.GetExercises();
                                if (exercises.size() != 0) {
                                    do {
                                        int i = 1;
                                        for (Exercise exercise : exercises) {
                                            System.out.println("\n " + i + ". " + exercise.getName());
                                            i++;
                                        }
                                        System.out.println("\n If you want to see more info about a exercise type the number associated with it");
                                        option = sc.nextLine();
                                        try {
                                            int index = Integer.parseInt(option) - 1;
                                            Exercise exercise = _splitController.GetExercise(exercises.get(index).getId());
                                            System.out.println("\n Your exercise is: " + exercise.getName());
                                            System.out.println("\n Description: " + exercise.getDescr());
                                            System.out.println("\n Muscle group targeted: " + exercise.getMuscleGroup());
                                            if (exercise.getClass() == Bodybuilding_Exercise.class) {
                                                System.out.println("\n No of reps:  " + ((Bodybuilding_Exercise) exercise).getRepsNo());
                                                System.out.println("\n Weight:  " + ((Bodybuilding_Exercise) exercise).getWeight());
                                            } else if (exercise.getClass() == Cardio_Exercise.class) {
                                                System.out.println("\n Time:  " + ((Cardio_Exercise) exercise).getTime());
                                                System.out.println("\n Distance:  " + ((Cardio_Exercise) exercise).getDistance());
                                            }
                                        } catch (Exception e) {

                                        }
                                    } while (!option.equals("stop") && !option.equals("back"));
                                } else {
                                    System.out.println("\n There are no exercises! Create some exercises and come back!");
                                }
                                break;
                            }
                        }
                    }
                } while (!option.equals("back") && !option.equals("stop"));
            }

        } while (!option.equals("stop"));
        sc.close();
    }
}