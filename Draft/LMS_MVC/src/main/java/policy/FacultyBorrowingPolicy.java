package policy;
import java.time.Period;

public class FacultyBorrowingPolicy implements BorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 5; 
    }

    public int getMaxReservationsAllowed() {
        return 3; 
    }
    
    public Period loanPeriod() {
        return Period.ofWeeks(4); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 0.25; 
    }
}
