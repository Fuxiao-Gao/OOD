import java.util.*;

public class LibraryManagementSystem {
    private ArrayList<BookItem> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    // use default constructor

    // make a reservation for a book
    public Reservation makeReservation(BookItem book, Member member) {
        // downcast the book to book item
        book = (BookItem) book;
        Date date = new Date();
        Reservation reservation = new Reservation(date, book, ReservationStatus.REQUESTED);
        reservations.add(reservation);
        member.addReservation(reservation);
        return reservation;
    }
}