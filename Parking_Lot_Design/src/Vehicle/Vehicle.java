package Vehicle;
import User.User;

import java.util.Objects;
import User.RegularUser;

public abstract class Vehicle {
//    vehicle is immutable since
//    1. all fields are private final
//    2. there are no setter methods
    private final String licensePlate;
    private final CarSize size;
    private final RegularUser owner;

    protected Vehicle(String licensePlate, CarSize size, RegularUser owner){
        this.licensePlate = Objects.requireNonNull(licensePlate);
        this.size = Objects.requireNonNull(size);
        this.owner = owner;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public CarSize getSize(){
        return size;
    }

    public RegularUser getOwner(){
        return owner;
    }

    @Override
    public String toString(){
        return String.format("Vehicle with license plate %s and size of %s",
                licensePlate, size.toString());
    }
}
