package ObserverLogin;

import Model.UserModel.User;

import java.sql.SQLException;

public  interface Observer{
    public void update (User userModel) throws SQLException, ClassNotFoundException;
}