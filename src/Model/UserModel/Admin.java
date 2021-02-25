package Model.UserModel;

import Queries.UserQuery.AdminQuery;

import java.sql.SQLException;

public class Admin extends User {
    private static final String category = "Admin";


    public Admin(String id, String password) {
        super(id, password);
    }

    @Override
    public String getCategory() {
        return Admin.category;
    }

    @Override
    public void getUserByIdAndPassword() throws SQLException {
        AdminQuery admQuery = new AdminQuery();
        admQuery.getUserByIdAndPassword(this);
    }

    @Override
    public void getUserById() {

        AdminQuery admQuery = new AdminQuery();
        admQuery.getUserById(this);
    }

}
