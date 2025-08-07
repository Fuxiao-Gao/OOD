package Parking;

import java.util.ArrayList;
import java.util.List;
import Vehicle.Vehicle;

//singleton
public class ParkingLot {
    // Private static instance
    private static ParkingLot instance;
    private List<ParkingFloor> floors;

    // Private constructor prevents external instantiation
    private ParkingLot(){
        this.floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) return spot;
        }
        return null;
    }

    public ParkingSpot findOccupiedSpot(Vehicle vehicle){
        for (ParkingFloor floor: floors){
            ParkingSpot spot = floor.findOccupiedSpot(vehicle);
            if (spot != null) return spot;
        }
        return null;
    }
    public void releaseSpot(ParkingSpot spot){
        spot.removeVehicle();
    }

//  the synchronized keyword makes the entire method thread-safe by acquiring a lock before executing.
//  the static keyword mean
//  1. you don't need to instantiate the class to use the method or field
//  2. it is shared across all instances of the class
}
