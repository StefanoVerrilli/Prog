package Route;

import Controller.SearchController;
import MainFrame.MainFrame;
import Model.UserModel.User;
import View.ClientView.HomeView;
import View.ClientView.NoleggioView.NoleggioPanel;
import View.GeneralComponentHomeView.MainPane.MainPane;
import View.LoginView.LoginAttempT;

import java.sql.SQLException;

public class HomeClientFactory implements HomeFactory {
    @Override
    public void createHome(LoginAttempT loginView, User userModel) throws SQLException, ClassNotFoundException {

        MainFrame.getInstance().remove(loginView.getPanel());
        HomeView home = new HomeView();
        SearchController searchController = new SearchController(home.Noleggio);
        MainFrame.getInstance().add(home);
        MainFrame.getInstance().repaint();
        MainFrame.getInstance().revalidate();

    }
}
