import java.util.ArrayList;
import java.util.Date;
public class Member {
    private static int idCounter;
    private String memberId;
    private Date dateOfMembership;
    private String email;
    private String address;
    private ArrayList<BookItem> booksCheckedOut;
    private ArrayList<Reservation> reservations;

    public Member(String email, String address) {
        this.memberId = String.valueOf(++idCounter);
        this.email = email;
        this.address = address;
        this.dateOfMembership = new Date();
        booksCheckedOut = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public int getTotalCheckedOutBooks() {
        return booksCheckedOut.size();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

}
