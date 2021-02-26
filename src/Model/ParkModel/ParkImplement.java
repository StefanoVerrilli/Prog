package Model.ParkModel;

import Database.GenericDb;
import ObserverPark.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ParkImplement implements Observable {

    private ArrayList<Observer> views = new ArrayList<Observer>();
    private ArrayList<Park> parks;

    public ParkImplement(){}

    public void getParksQuery() throws SQLException{
        parks = GenericDb.getIstance().getParkings();
    }

    public ArrayList<Park> getParks(){
        return parks;
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
        for(Observer observer : views){
            observer.update(this);
        }
    }
}
