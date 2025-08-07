package Vehicle;

import User.RegularUser;

public class Car extends Vehicle{
    public Car(String licensePlate, RegularUser owner){
        super(licensePlate, CarSize.MEDIUM, owner);
    }
}
