package Route;

import MainFrame.MainFrame;
import Model.UserModel.User;
import View.LoginView.LoginAttempT;

import java.sql.SQLException;

public interface HomeFactory {
    void createHome(LoginAttempT loginView, User userModel) throws SQLException, ClassNotFoundException;
}
