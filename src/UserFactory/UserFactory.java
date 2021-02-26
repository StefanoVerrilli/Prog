package UserFactory;

import Model.UserModel.*;

public class UserFactory {

    public UserFactory() {
    }

    public static UserImplement createUser(UserImplement userImplement) {

        String prefix = userImplement.getUser().getId().substring(0, 3);


        switch (prefix) {
            case "000" -> userImplement = new AdminImplement(new Admin(userImplement.getUser().getId(), userImplement.getUser().getPassword()));
            case "111" -> userImplement = new OperatorImplement(new Operator(userImplement.getUser().getId(), userImplement.getUser().getPassword()));
            case "222" -> userImplement = new IncidentManagerImplement(new IncidentManager(userImplement.getUser().getId(), userImplement.getUser().getPassword()));
            case "333" -> userImplement = new ClientImplement(new Client(userImplement.getUser().getId(), userImplement.getUser().getPassword()));

        }
        System.out.println(userImplement.getUser().getCategory());

        return userImplement;
    }

}
