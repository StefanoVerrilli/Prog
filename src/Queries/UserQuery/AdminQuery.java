package Queries.UserQuery;

import Database.GenericDb;
import Model.UserModel.Client;
import Model.UserModel.User;
import Model.UserModel.Admin;
import DataTest.*;
import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.sql.SQLException;

public class AdminQuery implements UsersQuery {

    @Override
    public void getUserByIdAndPassword(User userModel) throws SQLException {

        if (userModel.getId().equals(DataTestAdmin.id) && userModel.getPassword().equals(DataTestAdmin.password)) {
            userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));
            GenericDb.getIstance().loginAdmin((Admin)userModel);
        }
    }

    @Override
    public void getUserById(User userModel) {
            //
    }

}
