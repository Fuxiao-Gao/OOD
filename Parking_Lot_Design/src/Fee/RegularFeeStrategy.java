package Fee;

public class RegularFeeStrategy implements FeeStrategy {
    /*
    regular user gets 1 hour of free parking
     */
    public double calculateFee(Ticket ticket){
        long duration = ticket.getExitTime().getTime() - ticket.getEntryTime().getTime();
        duration -= 60 * 60* 1000;
        return duration * 0.05;
    }
}
