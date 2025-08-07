package Parking;

public interface ParkingObserver {
    void update(ParkingEventType eventType, ParkingSpot spot);
}
