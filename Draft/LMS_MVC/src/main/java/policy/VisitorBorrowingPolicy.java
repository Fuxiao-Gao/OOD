package policy;
import java.time.Period;

public class VisitorBorrowingPolicy implements BorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 1; 
    }

    public int getMaxReservationsAllowed() {
        return 1; 
    }

    public Period loanPeriod() {
        return Period.ofWeeks(1); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 1.00; 
    }

    
}
