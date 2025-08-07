package Parking;
import Vehicle.Vehicle;
import Vehicle.CarSize;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingSpot {
    private String spotId;
    private CarSize size;
    private boolean isOccupied;
    private Vehicle vehicle;
    private List<ParkingObserver> observers = new ArrayList<>();

    public ParkingSpot(String spotId, CarSize size){
        this.spotId = Objects.requireNonNull(spotId);
        this.size = Objects.requireNonNull(size);
        this.isOccupied = false;
        this.vehicle = null;
    }

    // Copy constructor
    private ParkingSpot(ParkingSpot other) {
        this.spotId = other.spotId;
        this.size = other.size;
        this.isOccupied = other.isOccupied;
        this.vehicle = other.vehicle;
    }

    // Convenience copy method
    public ParkingSpot copy() {
        return new ParkingSpot(this);
    }

    public void addObserver(ParkingObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ParkingObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(ParkingEventType eventType){
        for(ParkingObserver observer: observers) {
            observer.update(eventType, this);
        }
    }

    public void assignVehicle(Vehicle vehicle){
        if (isOccupied){
            throw new IllegalStateException("Spot already occupied");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
        notifyObservers(ParkingEventType.OCCUPIED);
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isOccupied = false;
        notifyObservers(ParkingEventType.VACATED);
    }

    public String getSpotId(){
        return spotId;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

//    vehicle is immutable as it has private final fields and no setters
    public Vehicle getVehicle(){
        return vehicle;
    }

    public CarSize getSize() {
        return size;
    }

    public String toString(){
        return "Spot with spotId " + spotId + " and size " + size;
    }
}
