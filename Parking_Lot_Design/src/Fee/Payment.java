package Fee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Payment {
    private String paymentId;
    private double amount;
    private Date paymentTime;
    private Ticket ticket;
    private List<PaymentObserver> observers;

    public Payment(String paymentId, double amount, Ticket ticket){
        this.paymentId = paymentId;
        this.amount = amount;
        this.ticket = ticket;
        this.paymentTime = new Date();
        this.observers = new ArrayList<>();
    }

    public void addObserver(PaymentObserver observer){
        observers.add(observer);
    }

    public void removeObserver(PaymentObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (PaymentObserver observer: observers){
            observer.update(this);
        }
    }
    public boolean processPayment(){
//        assume payment is successful
        notifyObservers();
        return true;
    }

    public String getPaymentId(){
        return paymentId;
    }

    public Ticket getTicket(){
        return ticket;
    }
}
