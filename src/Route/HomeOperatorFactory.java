package Route;

import Model.UserModel.Operator;
import Model.UserModel.User;
import View.LoginView.LoginAttempT;

public class HomeOperatorFactory implements HomeFactory {
    @Override
    public void createHome(LoginAttempT loginView, User userModel) {

        /*
            OperatorView operator = new OperatorView();
            loginView.getMainFrame().add(operator);
            loginView.getMainFrame().repaint();
            loginView.getMainFrame().revalidate(); */
    }
}
