package Route;

import Model.UserModel.User;
import View.ClientView.HomeView;
import View.LoginView.LoginAttempT;

public class HomeClientFactory implements HomeFactory {
    @Override
    public void createHome(LoginAttempT loginView, User userModel) {

        loginView.getMainFrame().remove(loginView.getPanel());
        HomeView home = new HomeView();
        loginView.getMainFrame().add(home);
        loginView.getMainFrame().repaint();
        loginView.getMainFrame().revalidate();

    }
}
