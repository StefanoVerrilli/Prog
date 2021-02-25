package Queries.UserQuery;

import Database.GenericDb;
import Model.UserModel.IncidentManager;
import Model.UserModel.User;
import Model.UserModel.Operator;
import DataTest.*;

import java.sql.SQLException;

public class OperatorQuery implements UsersQuery {

    Operator operator = null;

    @Override
    public void getUserByIdAndPassword(User userModel) throws SQLException {
        userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));
        GenericDb.getIstance().loginOperator((Operator) userModel);
        userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));
    }

    @Override
    public void getUserById(User userModel) {
        //
    }

}