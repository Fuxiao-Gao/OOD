package Vehicle;

import User.User;
import User.RegularUser;

public class Truck extends Vehicle{
    public Truck(String licensePlate, RegularUser owner){
        super(licensePlate, CarSize.LARGE, owner);
    }
}
