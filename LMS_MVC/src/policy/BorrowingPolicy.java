package policy;
import java.time.Period;
import model.Book;

public interface BorrowingPolicy {
    int getMaxBooksAllowed();
    boolean canRenew(Book book);
    Period loanPeriod();
    double calculateFines(int overdueDays);
}
