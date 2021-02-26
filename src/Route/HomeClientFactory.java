package Route;

import Controller.ParkController;
import MainFrame.MainFrame;
import Model.UserModel.User;
import View.ClientView.HomeView;
import View.LoginView.LoginAttempT;

import java.sql.SQLException;

public class HomeClientFactory implements HomeFactory {
    @Override
    public void createHome(LoginAttempT loginView, User userModel) throws SQLException, ClassNotFoundException {

        MainFrame.getInstance().remove(loginView.getPanel());
        HomeView home = new HomeView();
        ParkController parkController = new ParkController(home.Noleggio);
        MainFrame.getInstance().add(home);
        MainFrame.getInstance().repaint();
        MainFrame.getInstance().revalidate();

    }
}
