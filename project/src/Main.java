import Controller.SplitController;
import Controller.UserController;
import Model.*;
import Model.Enums.Muscle_Groups;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        CRUDMenu menu = CRUDMenu.getInstance();
        menu.SeeMenu();
    }
}