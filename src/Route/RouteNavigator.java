package Route;

import Controller.LoginController;
import Controller.SearchController;
import View.LoginView.LoginAttempT;
import MainFrame.MainFrame;
import Model.UserModel.User;
import View.LoginView.LoginPanel;
import View.ViewPanel;

import java.sql.SQLException;

public class RouteNavigator {

    public static void selectHome(LoginAttempT loginView, User userModel) throws SQLException, ClassNotFoundException {

        HomeFactory genericHomeView;


        switch (userModel.getCategory()) {
            case "Admin" -> {
                genericHomeView = new HomeAdminFactory();
                genericHomeView.createHome(loginView, userModel);
            }
            case "Operator" -> {
                genericHomeView = new HomeOperatorFactory();
                genericHomeView.createHome(loginView, userModel);
            }
            case "IncidentManager" -> {
                genericHomeView = new HomeIncidentFactory();
                genericHomeView.createHome(loginView, userModel);
            }
            case "Client" -> {
                genericHomeView = new HomeClientFactory();
                genericHomeView.createHome(loginView, userModel);

            }
        }
    }

    public static void selectView(String typeView, ViewPanel panel) {
        switch (typeView) {
            case "Login" -> {

                User user = new User();
                if (panel != null) {

                    MainFrame.getInstance().remove(panel.getPanel());
                    LoginPanel login = new LoginPanel(MainFrame.getInstance());
                    LoginController controller = new LoginController( login.getSubmit());
                    MainFrame.getInstance().add(login);
                    MainFrame.getInstance().repaint();
                    MainFrame.getInstance().revalidate();
                } else {
                    LoginController UserController = new LoginController(MainFrame.getInstance().getPanel().getSubmit());
                }
            }
        }
    }

}
