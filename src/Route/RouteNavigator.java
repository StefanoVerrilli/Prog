package Route;

import Controller.LoginController;
import View.LoginView.LoginAttempT;
import MainFrame.MainFrame;
import Model.UserModel.User;
import View.LoginView.LoginPanel;
import View.ViewPanel;

import java.sql.SQLException;

public class RouteNavigator {

    public static void selectHome(LoginAttempT loginView, User userModel) throws SQLException {

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
        MainFrame mainFrame;
        switch (typeView) {
            case "Login" -> {

                User user = new User();
                if (panel != null) {
                    mainFrame = panel.getFrame();
                    mainFrame.remove(panel.getPanel());
                    LoginPanel login = new LoginPanel(mainFrame);
                    LoginController controller = new LoginController( login.getSubmit());
                    mainFrame.add(login);
                    mainFrame.repaint();
                    mainFrame.revalidate();
                } else {
                    mainFrame = new MainFrame();
                    LoginController UserController = new LoginController(mainFrame.getPanel().getSubmit());
                }
            }
        }
    }

}
