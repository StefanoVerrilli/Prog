package Queries.UserQuery;

import Database.GenericDb;
import Model.UserModel.Admin;
import Model.UserModel.User;
import Model.UserModel.IncidentManager;
import DataTest.*;

import java.sql.SQLException;

public class IncidentManagerQuery implements UsersQuery {

    IncidentManager incidentManager = null;

    @Override
    public void getUserByIdAndPassword(User userModel) throws SQLException {

        userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));
        GenericDb.getIstance().loginIncidentManager((IncidentManager) userModel);
        userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));

    }

    @Override
    public void getUserById(User userModel) {
        //
    }
}
