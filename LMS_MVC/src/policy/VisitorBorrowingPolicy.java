package policy;
import java.time.Period;
import model.Book;

public class VisitorBorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 1; 
    }

    public boolean canRenew(Book book) {
        return false; 
    }

    public Period loanPeriod() {
        return Period.ofWeeks(1); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 1.00; 
    }

    
}
