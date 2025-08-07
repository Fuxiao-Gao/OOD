package Fee;

public class PremiumFeeStrategy implements FeeStrategy{
    /*
    premium user gets two hours of free parking
     */
    public double calculateFee(Ticket ticket){
        long duration = ticket.getExitTime().getTime() - ticket.getEntryTime().getTime();
        duration -= 2 * 60 * 60 * 1000;
        return duration * 0.05;
    }
}
