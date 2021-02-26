package Model.ParkModel;

import ObserverPark.Observable;
import ObserverPark.Observer;

import java.sql.SQLException;
import java.util.ArrayList;

public class Park {
    private String name;
    private Integer id;
    private String street;
    private int capacity;
    private int latitude;
    private int longitude;
    ArrayList<Auto> autoCollection;


    public Park(String name, Integer id, String street, int capacity, int latitude, int longitude) {
        this.name = name;
        this.id = id;
        this.street = street;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Park(){

    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAutoCollection(ArrayList<Auto> autoCollection) {
        this.autoCollection = autoCollection;
    }

    public ArrayList<Auto> getAutoCollection() {
        return autoCollection;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

}
