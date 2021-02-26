package Controller;

import ObserverLogin.*;
import Model.UserModel.User;
import Model.UserModel.Client;
import DataTest.*;
import Route.RouteNavigator;
import View.RegisterView.RegisterAttempt;

import java.sql.SQLException;

public class RegisterController implements Observer {

    private User userModel;
    private RegisterAttempt registerView;

    public RegisterController(RegisterAttempt registerAttempT) {
        this.registerView = registerAttempT;
        this.registerView.attach(this);
    }

    @Override
    public void update(User userModel) throws SQLException, ClassNotFoundException {

        Client user = (Client)userModel;

        user.setUserById();
        userModel.inform();
        if(user.getState())
            RouteNavigator.selectView("Login", registerView);
        
    }
    
}
