package model;
import java.time.LocalDate;

public class Reservation {
    public enum ReservationStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
    private Book book;
    private Member member;
    private LocalDate reservationDate;
    private ReservationStatus status;

    public Reservation(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.reservationDate = LocalDate.now();
        this.status = ReservationStatus.PENDING;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "book=" + book.getTitle() +
                ", member=" + member.getName() +
                ", reservationDate=" + reservationDate +
                ", status=" + status +
                '}';
    }
}
