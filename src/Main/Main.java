package Main;

import Controller.LoginController;
import Database.GenericDb;
import MainFrame.MainFrame;
import Model.UserModel.User;
import Route.RouteNavigator;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        GenericDb.getIstance().main();

        RouteNavigator.selectView("Login",null);

    }
}