package Route;

import MainFrame.MainFrame;
import Model.UserModel.User;
import View.AdminView.AdminView;
import View.LoginView.LoginAttempT;

public class HomeAdminFactory implements HomeFactory {


    public void createHome(LoginAttempT loginView, User userModel) {

        MainFrame.getInstance().remove(loginView.getPanel());
        AdminView admin = new AdminView();
        MainFrame.getInstance().add(admin);
        MainFrame.getInstance().repaint();
        MainFrame.getInstance().revalidate();

    }
}
