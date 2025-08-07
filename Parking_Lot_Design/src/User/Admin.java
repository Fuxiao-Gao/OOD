package User;
import Fee.Payment;
import Fee.PaymentObserver;
import Parking.ParkingFloor;
import Parking.ParkingLot;
import Parking.ParkingSpot;
import Vehicle.CarSize;
import java.util.List;

/*
Admins can configure parking lot settings, including pricing and floor management
 */
public class Admin extends User implements PaymentObserver {
    public Admin(String userId, String name){
        super(userId, name);
    }

    public ParkingFloor createParkingFloor(int level, List<ParkingSpot> spots){
//        System.out.println("parking floor " + level + " has been created.");
        return new ParkingFloor(level, spots);
    }

    public ParkingSpot createParkingSpot(String spotId, CarSize size){
//        System.out.println("spot" + spotId + " with size " + size.name() + " has been created.");
        return new ParkingSpot(spotId, size);
    }

    public void addFloor(ParkingFloor floor){
        ParkingLot parkinglot = ParkingLot.getInstance();
        parkinglot.addFloor(floor);
    }

    public void update(Payment payment){
        System.out.println("Admin " + getUserId() + "Notification: " + "The payment with payment id " + payment.getPaymentId() + " has been paid");
    }
}
