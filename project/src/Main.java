import Controller.SplitController;
import Controller.UserController;
import Model.Enums.Muscle_Groups;
import Model.Exercise;
import Model.User;

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
                    } else {
                        switch (option) {
                            case "2" -> {
                                System.out.println("not implemented 2");
                                break;
                            }
                            case "3" -> {
                                System.out.println("not implemented 3");
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
                                for(Muscle_Groups value: Muscle_Groups.values()){
                                    System.out.println("\n" + value.getLabel() + ": " + value.name());
                                }
                                option = sc.nextLine();
                                try {
                                    int index = Integer.parseInt(option);
                                    Muscle_Groups mg = Arrays.stream(Muscle_Groups.values()).filter(e -> e.getLabel() == index).findFirst().get();
                                    newExercise.setMuscleGroup(mg);
                                } catch (Exception e) {

                                }
                                _splitController.AddExercise(newExercise);
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
                                System.out.println("not implemented 2");
                                break;
                            }
                            case "3": {
                                System.out.println("not implemented 3");
                                break;
                            }
                            case "4": {
                                System.out.println("not implemented 4");
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