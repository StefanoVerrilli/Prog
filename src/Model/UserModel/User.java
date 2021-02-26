package Model.UserModel;

import ObserverLogin.Observable;
import ObserverLogin.Observer;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;


public class User implements Observable {
    private ArrayList<Observer> views = new ArrayList<Observer>();
    private String id;
    private String password;
    private String name;
    private String surname;
    private Boolean state = false;
    private static final String category = "GenericUser";


    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String prefixid) {
        this.id = prefixid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getCategory() {
        return category;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public void attach(Observer observer) {
        views.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        views.remove(observer);
    }

    @Override
    public void inform() throws SQLException, ClassNotFoundException {
        for (Observer observer : views) {

            observer.update(this);
        }
    }

    public void getUserByIdAndPassword() throws SQLException, ClassNotFoundException {

    }

    public void getUserById(){
         //
    }

	public void setUserById() throws SQLException {
      //
	}
    
}
