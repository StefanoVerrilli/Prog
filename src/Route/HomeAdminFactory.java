package Route;

import Model.UserModel.User;
import View.AdminView.AdminView;
import View.LoginView.LoginAttempT;

public class HomeAdminFactory implements HomeFactory {


    public void createHome(LoginAttempT loginView, User userModel) {

        loginView.getMainFrame().remove(loginView.getPanel());
        AdminView admin = new AdminView();
        loginView.getMainFrame().add(admin);
        loginView.getMainFrame().repaint();
        loginView.getMainFrame().revalidate();

    }
}
