package Controller;

import ObserverLogin.Observer;
import Model.UserModel.User;
import View.LoginView.LoginAttempT;
import UserFactory.*;
import Route.RouteNavigator;

import java.sql.SQLException;

public class LoginController implements Observer {

    private User userModel;
    private LoginAttempT loginView;

    public LoginController( LoginAttempT loginAttempT) {
        this.loginView = loginAttempT;
        this.loginView.attach(this);
    }

    @Override
    public void update(User userTempModel) throws SQLException, ClassNotFoundException {
        //Create Model
        userModel = new UserFactory().createUser(userTempModel);

        //Query
        userModel.getUserByIdAndPassword();

        //Attach view to "new" Model
        if(!userModel.equals(userTempModel)) userModel.attach(loginView);

        //Notify View
        userModel.inform();

        //SwitchView
        if (userModel.getState()) RouteNavigator.selectHome(loginView, userModel);
    }

    public User getUserModel() {
        return userModel;
    }

    public LoginAttempT getLoginView() {
        return loginView;
    }


}
