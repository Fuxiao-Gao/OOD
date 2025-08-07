package Fee;

import Parking.ParkingSpot;
import Vehicle.Vehicle;
import java.util.Date;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private Date entryTime;
    private Date exitTime;
    private double fee;
    private FeeStrategy feeStrategy;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, FeeStrategy feeStrategy){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = new Date();
        this.feeStrategy = feeStrategy;
    }

    public void markExit(){
        this.exitTime = new Date();
        calculateFee();
    }

    private void calculateFee(){
        this.fee = feeStrategy.calculateFee(this);
    }

    public double getFee(){
        return fee;
    }

    public Date getEntryTime(){
        return new Date(this.entryTime.getTime());
    }

    public Date getExitTime(){
        return new Date(this.exitTime.getTime());
    }

    public ParkingSpot getSpot(){
        return spot;
    }

    public String getTicketId(){
        return ticketId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

}
