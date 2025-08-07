package Vehicle;

import User.RegularUser;

public class Bike extends Vehicle{
    public Bike(String licensePlate, RegularUser owner) {
        super(licensePlate, CarSize.SMALL, owner);
    }
}
