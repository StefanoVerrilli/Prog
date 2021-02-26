package Controller;

import Model.StateModel.State;
import Model.UserModel.UserImplement;
import ObserverLogin.Observer;
import Model.UserModel.User;
import UserFactory.UserFactory;
import View.LoginView.LoginAttempT;
import Route.RouteNavigator;

import java.sql.SQLException;

public class LoginController implements Observer {

    private UserImplement userImplement;
    private LoginAttempT loginView;

    public LoginController(LoginAttempT loginAttempT) {
        this.loginView = loginAttempT;
        this.loginView.attach(this);
    }

    @Override
    public void update(T userTempModel) throws SQLException, ClassNotFoundException {
        //Create Model
        userImplement = UserFactory.createUser((UserImplement)userTempModel);


        //Query
        userImplement.setUserByIdAndPassword();



        //Attach view to "new" Model
        if (!userImplement.equals(userTempModel)) userImplement.attach(loginView);

        //Notify View
        userImplement.inform();

        //SwitchView
        if (userImplement.getUser().getState()) {
            State.getIstance().setId(userImplement.getUser().getId());
            State.getIstance().setCategory(userImplement.getUser().getCategory());
            System.out.println(State.getIstance().getId());
            RouteNavigator.selectHome(loginView, userImplement.getUser());
        }
    }
        public UserImplement getUserModel () {
            return userImplement;
        }

        public LoginAttempT getLoginView () {
            return loginView;
        }

}
