package Model.UserModel;

import Queries.UserQuery.IncidentManagerQuery;

import java.sql.SQLException;

public class IncidentManager extends User {
    private static final String category = "IncidentManager";

    public IncidentManager(String id, String password) {
        super(id, password);
    }

    @Override
    public String getCategory() {
        return IncidentManager.category;
    }

    @Override
    public void getUserByIdAndPassword() throws SQLException {

        IncidentManagerQuery IncidentManagerQuery = new IncidentManagerQuery();
        IncidentManagerQuery.getUserByIdAndPassword(this);
    }

    @Override
    public void getUserById() {

        IncidentManagerQuery IncidentManagerQuery = new IncidentManagerQuery();
        IncidentManagerQuery.getUserById(this);
    }
}
