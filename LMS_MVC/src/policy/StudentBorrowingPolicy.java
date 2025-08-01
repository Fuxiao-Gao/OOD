package policy;
import java.time.Period;

public class StudentBorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 2; 
    }

    public boolean canRenew(Book book) {
        return false; 
    }

    public Period loanPeriod() {
        return Period.ofWeeks(2); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 0.50; 
    }
}
