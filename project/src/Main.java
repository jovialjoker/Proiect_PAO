import Controller.SplitController;
import Controller.UserController;
import Model.*;
import Model.Enums.Muscle_Groups;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        CRUDMenu menu = CRUDMenu.getInstance();
        menu.SeeMenu();
    }
}