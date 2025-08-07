package User;
import Fee.Payment;
import Fee.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {
    private String userId;
    private String name;

    protected User(String userId, String name){
        this.userId = Objects.requireNonNull(userId);
        this.name = Objects.requireNonNull(name);
    }

    public String getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }




}
