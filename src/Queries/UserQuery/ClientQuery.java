package Queries.UserQuery;

import Database.GenericDb;
import Model.UserModel.Client;
import Model.UserModel.User;

import java.sql.SQLException;

public class ClientQuery implements UsersQuery {


    @Override
    public void getUserByIdAndPassword(User userModel) throws SQLException, ClassNotFoundException {
        //Instanziarlo per fare le query serve
        userModel.setPassword(HashPassword.encrypt(userModel.getPassword()));
        GenericDb.getIstance().loginClient((Client) userModel);
    }

    @Override
    public void getUserById(User userModel) {
        //
    }

    public void setUserById(Client client) throws SQLException {

        client.setPassword(HashPassword.encrypt(client.getPassword()));
        GenericDb.getIstance().insertClients(client);
    }

}
