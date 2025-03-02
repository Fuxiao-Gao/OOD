import java.util.Date;

public class Reservation {
    private Date creationDate;
    private BookItem book;
    private ReservationStatus status;

    public Reservation(Date creationDate, BookItem book, ReservationStatus status) {
        this.creationDate = creationDate;
        this.book = book;
        this.status = status;
    }
    
}
