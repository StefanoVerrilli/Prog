package Model.UserModel;

import Queries.UserQuery.OperatorQuery;

import java.sql.SQLException;

public class Operator extends User {
    private static final String category = "Operator";

    public Operator(String id, String password) {
        super(id, password);
    }

    @Override
    public String getCategory(){
        return category;
    }
}
