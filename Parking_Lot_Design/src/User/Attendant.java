package User;

import Fee.FeeStrategy;
import Fee.Payment;
import Fee.Ticket;
import Parking.ParkingEventType;
import Parking.ParkingLot;
import Parking.ParkingObserver;
import Parking.ParkingSpot;
import Vehicle.Vehicle;

import java.text.SimpleDateFormat;

/*
Attendants can check-in/check-out vehicles and manage spot assignments.
 */
public class Attendant extends User implements ParkingObserver {
    public Attendant(String userId, String name){
        super(userId, name);
    }

    public void update(ParkingEventType eventType, ParkingSpot spot){
        switch(eventType){
            case OCCUPIED -> handleOccupied(spot);
            case VACATED -> handleVacated(spot);
        }
    }

    private void handleOccupied(ParkingSpot spot){
        System.out.println("Attendant " + getUserId() + " Notification: Spot " + spot.getSpotId() + " is now occupied");
    }

    private void handleVacated(ParkingSpot spot) {
        System.out.println("Attendant " + getUserId() + " Notification: Spot " + spot.getSpotId() + " is now vacated");
    }

    public Ticket checkinVehicle(Vehicle vehicle, String ticketId, FeeStrategy feeStrategy){
//        find spot
        ParkingLot parkinglot = ParkingLot.getInstance();
        ParkingSpot spot = parkinglot.findAvailableSpot(vehicle);
//        generate a ticket
        Ticket ticket = new Ticket(ticketId, vehicle, spot, feeStrategy);
//        assign the ticket to the owner
        RegularUser owner = vehicle.getOwner();
        owner.addTicket(ticket);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(ticket.getEntryTime());
        String record = "Your vehicle " + vehicle.getLicensePlate() + " has been checked in at " + formattedDate;
        owner.addParkingHistory(record);
        return ticket;
    }

    public Payment checkoutVehicle(Ticket ticket, String paymentId) {
        Vehicle vehicle = ticket.getVehicle();
        ParkingSpot spot = ticket.getSpot();
        spot.removeVehicle();
        ticket.markExit();
        double fee = ticket.getFee();
//        generates a new payment
        Payment payment = new Payment(paymentId, fee, ticket);
        RegularUser owner = vehicle.getOwner();
        owner.addPayment(payment);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(ticket.getExitTime());
        String record = "Your vehicle " + vehicle.getLicensePlate() + " has been checked out at " + formattedDate;
        owner.addParkingHistory(record);
        return payment;
    }

}
