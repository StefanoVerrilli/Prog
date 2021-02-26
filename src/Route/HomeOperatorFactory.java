package Route;

import Model.UserModel.Operator;
import Model.UserModel.User;
import View.LoginView.LoginAttempT;

public class HomeOperatorFactory implements HomeFactory {
    @Override
    public void createHome(LoginAttempT loginView, User userModel) {

        /*
            OperatorView operator = new OperatorView();
            MainFrame.getInstance().add(operator);
            MainFrame.getInstance().repaint();
            MainFrame.getInstance().revalidate(); */
    }
}
