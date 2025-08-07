package Main;

import Fee.*;
import Parking.ParkingFloor;
import Parking.ParkingLot;
import Parking.ParkingSpot;
import User.Admin;
import User.Attendant;
import User.RegularUser;
import User.User;
import Vehicle.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*
    The reference type if vehicle, the object type is car.
    you can only call methods defined in Vehicle, if car overrides a method from vehicle, the car version runs.
    Vehicle car = new Car("carA12");

    Both reference and object are the same type
    you can call all methods in car and all methods from vehicle.
    Car car = new Car("carA12");

    Reference type decides what methods and fields you can access at compile time.
    Object type decides what implementation of overriden methods will run at runtime.
 */
        ArrayList<User> regularUsers = new ArrayList<User>();
        RegularUser carOwner = new RegularUser("userCarA12", "Jenny");
        RegularUser bikeOwner = new RegularUser("userBikeA12", "Alex");
        RegularUser truckOwner = new RegularUser("userTruckA12", "Andy");
        regularUsers.add(carOwner);
        regularUsers.add(bikeOwner);
        regularUsers.add(truckOwner);

        Car car = new Car("carA12", carOwner);
        Bike bike = new Bike("BikeA12", bikeOwner);
        Truck truck = new Truck("TruckA12", truckOwner);

//        let admin creates parking spots and floors
        Admin admin = new Admin("adminA12", "Jerry");
        Attendant attendant1 = new Attendant("attendantA12", "Max");
        Attendant attendant2 = new Attendant("attendantA13", "Joshua");
        int levels = 3;
        int spotsPerLevel = 3;
        CarSize[] sizes = CarSize.values();
        for (int i = 0; i < levels; i++) {
            List<ParkingSpot> spots = new ArrayList<>();
            for (int j = 0; j < spotsPerLevel; j++){
                String spotId = String.format("spot%d%d", i, j);
                ParkingSpot spot = admin.createParkingSpot(spotId, sizes[j]);
                spot.addObserver(attendant1);
                spot.addObserver(attendant2);
                spots.add(spot);
            }
            ParkingFloor floor = admin.createParkingFloor(i, spots);
            admin.addFloor(floor);
        }

//        attendant finds an available spot and check in
        FeeStrategy regularStrategy = new RegularFeeStrategy();
        FeeStrategy premiumStrategy = new PremiumFeeStrategy();
        Ticket ticketCar = attendant1.checkinVehicle(car, "ticketA12", regularStrategy);
        carOwner.viewParkingHistory();


        Ticket ticketTruck = attendant2.checkinVehicle(truck, "ticketA13", premiumStrategy);
        truckOwner.viewParkingHistory();

        System.out.println("------------------------------------------------------------");
        carOwner.viewTickets();
        truckOwner.viewTickets();

//        attendant check out the vehicles
        Payment paymentCar = attendant2.checkoutVehicle(ticketCar, "PaymentA12");
        Payment paymentTruck = attendant1.checkoutVehicle(ticketTruck, "PaymentA13");

        paymentCar.addObserver(admin);
        paymentTruck.addObserver(admin);

        carOwner.viewPayments();
        truckOwner.viewPayments();

        System.out.println("------------------------------------------------------------");

        carOwner.viewParkingHistory();
        truckOwner.viewParkingHistory();

        carOwner.pay(paymentCar);
        truckOwner.pay(paymentTruck);








    }
}
