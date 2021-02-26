package Model.UserModel;

import Queries.UserQuery.OperatorQuery;

import java.sql.SQLException;

public class Operator extends User {
    private static final String category = "Operator";

    public Operator(String id, String password) {
        super(id, password);
    }

    @Override
    public String getCategory() {
        return Operator.category;
    }

    @Override
    public void getUserByIdAndPassword() throws SQLException {
        OperatorQuery optQuery = new OperatorQuery();

          optQuery.getUserByIdAndPassword(this);
    }

    @Override
    public void getUserById() {
        OperatorQuery optQuery = new OperatorQuery();

       optQuery.getUserById(this);
    }

    @Override
    public void setUserById(){
        OperatorQuery optQuery = new OperatorQuery();
        //
    }
}
