package View.ClientView.NoleggioView;


import java.sql.SQLException;
import java.util.ArrayList;

public class Park  {
    private String name;
    private String id;
    private String street;
    private int capacity;
    private float latitude;
    private float longitude;
  //  ArrayList<Auto> autoCollection;

    Park(){

    }

    public Park(String name, String Indirizzo,float Lat,float Long){
        this.name = name;
        this.id = id;
        this.street = Indirizzo;
        this.capacity = capacity;
        this.latitude = Lat;
        this.longitude = Long;
      //  this.autoCollection = autoCollection;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
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

//    @Override
    //public void attach(Observer observer) {

    }

    //@Override
  //  public void detach(Observer observer) {

    //}

    //@Override
  //  public void inform() throws SQLException, ClassNotFoundException {

    //}

