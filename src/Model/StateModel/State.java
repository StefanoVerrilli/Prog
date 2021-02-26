package Model.StateModel;

import Database.GenericDb;
import Model.UserModel.User;

public class State {

    private static State istance;
    private  String id;
    private  String category;

    private State(){
        id = null;
        category = null;
    }

    public static synchronized State getIstance() {
        if (istance == null) {
            istance = new State();
        }

        return istance;
    }

    public void setId(String id) {
        if(this.id == null){
            this.id = id;
        }
    }

    public void setCategory(String category){
        if(this.category == null){
            this.category = category;
        }
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}
