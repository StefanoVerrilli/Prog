package UserFactory;

import Model.UserModel.*;

public class UserFactory {

    public UserFactory() {
    }

    public User createUser(User userModel) {

        String prefix = userModel.getId().substring(0, 3);

        switch (prefix) {
            case "000" -> userModel = new Admin(userModel.getId(), userModel.getPassword());
            case "111" -> userModel = new Operator(userModel.getId(), userModel.getPassword());
            case "222" -> userModel = new IncidentManager(userModel.getId(), userModel.getPassword());
            case "333" -> userModel = new Client(userModel.getId(), userModel.getPassword());
        }

        return userModel;
    }

}
