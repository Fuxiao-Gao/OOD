package policy;
import java.time.Period;
import model.Book;

public class FacultyBorrowingPolicy {
    public int getMaxBooksAllowed() {
        return 5; 
    }

    public boolean canRenew(Book book) {
        return true; 
    }

    public Period loanPeriod() {
        return Period.ofWeeks(4); 
    }

    public double calculateFines(int overdueDays) {
        return overdueDays * 0.25; 
    }
}
