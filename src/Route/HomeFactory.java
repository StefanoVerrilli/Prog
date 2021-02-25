package Route;

import MainFrame.MainFrame;
import Model.UserModel.User;
import View.LoginView.LoginAttempT;

public interface HomeFactory {
    void createHome(LoginAttempT loginView, User userModel);
}
