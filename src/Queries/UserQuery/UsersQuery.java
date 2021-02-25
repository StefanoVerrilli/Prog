package Queries.UserQuery;

import Model.UserModel.User;

import java.sql.SQLException;


public interface UsersQuery {
    public void getUserByIdAndPassword(User userModel) throws SQLException, ClassNotFoundException;

    public void getUserById(User userModel);
}
