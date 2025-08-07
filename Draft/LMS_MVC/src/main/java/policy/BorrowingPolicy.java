package policy;
import java.time.Period;

public interface BorrowingPolicy {
    int getMaxBooksAllowed();
    int getMaxReservationsAllowed();
    Period loanPeriod();
    double calculateFines(int overdueDays);
}
