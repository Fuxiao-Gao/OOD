package Parking;
import Vehicle.Vehicle;

import java.sql.Array;
import java.util.*;

public class ParkingFloor {
    private int level;
    private List<ParkingSpot> spots;

    public ParkingFloor(int level, List<ParkingSpot> spots){
        this.level = level;
        this.spots = Objects.requireNonNull(spots);
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle){
        for (ParkingSpot spot: spots) {
            if (!spot.isOccupied() && spot.getSize().equals(vehicle.getSize())){
                spot.assignVehicle(vehicle);
                return spot;
            }
        }
//        no spot available
        return null;
    }

    public ParkingSpot findOccupiedSpot(Vehicle vehicle) {
        for (ParkingSpot spot: spots) {
            if (spot.getVehicle() == vehicle){
                return spot;
            }
        }
        return null;
    }

    public int calculateAvailableSpots(){
        int count = 0;
        for (ParkingSpot spot: spots){
            if (!spot.isOccupied()){
                count++;
            }
        }
        return count;
    }

    public int getLevel() {
        return level;
    }

    public List<ParkingSpot> getSpotsOfFloor() {
        List<ParkingSpot> copy = new ArrayList<>(spots.size());
        for (ParkingSpot spot: spots){
            copy.add(spot.copy());
        }
        return copy;
    }
}
