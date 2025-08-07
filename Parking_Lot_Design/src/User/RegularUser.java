package User;

import Fee.Payment;
import Fee.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

/*
Users can reserve spots, check availability, and view their parking history.
 */
public class RegularUser extends User{
    private List<Ticket> tickets = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private List<String> parkingHistory = new ArrayList<>();

    public RegularUser(String userId, String name){
        super(userId, name);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void addParkingHistory(String record) {
        parkingHistory.add(record);
    }

    public void viewParkingHistory() {
        System.out.println("Parking history for user " + getUserId() + ":");
        for (String record : parkingHistory){
            System.out.println(record);
        }
    }

    public void pay(Payment payment) {
        payment.processPayment();
        payments.remove(payment);
        tickets.remove(payment.getTicket());
        System.out.println("Your fee has been paid");
    }

    public List<Ticket> viewTickets(){
        System.out.println("User " + getUserId() + " has " + tickets.size() + " tickets.");
        for (Ticket ticket: tickets) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = formatter.format(ticket.getEntryTime());
            System.out.println("Ticket " + ticket.getTicketId() + " with entry time " + formattedDate);
        }
        return tickets;
    }

    public List<Payment> viewPayments(){
        System.out.println("User " + getUserId() + " has " + payments.size() + " payments.");
        for (Payment payment : payments) {
            Ticket ticket = payment.getTicket();
            System.out.println("Payment " + payment.getPaymentId() + " for ticket " + ticket.getTicketId());
        }
        return payments;
    }
}
