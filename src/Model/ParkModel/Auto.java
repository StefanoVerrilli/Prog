package Model.ParkModel;

import ObserverCar.Observable;
import ObserverCar.Observer;

import java.sql.SQLException;

public class Auto implements Observable {
    private Integer id;
    private String carName;
    private String brand;
    private String carPlate;
    private Integer seats;
    private String color;
    private double euroMin;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public double getEuroMin() {
        return euroMin;
    }

    public String getColor() {
        return color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEuroMin(double euroMin) {
        this.euroMin = euroMin;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getSeats() {
        return seats;
    }

    @Override
    public void attach(Observer observer) {

    }

    @Override
    public void detach(Observer observer) {

    }

    @Override
    public void inform() throws SQLException, ClassNotFoundException {

    }
}
