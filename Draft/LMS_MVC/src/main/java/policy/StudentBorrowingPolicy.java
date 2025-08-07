package policy;
import java.time.Period;

public class StudentBorrowingPolicy implements BorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 2; 
    }

    public int getMaxReservationsAllowed() {
        return 2; 
    }
    
    public Period loanPeriod() {
        return Period.ofWeeks(2); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 0.50; 
    }
}
