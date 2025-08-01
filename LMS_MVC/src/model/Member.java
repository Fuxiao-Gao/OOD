package model;
import java.util.*;
import java.time.LocalDate;

public abstract class Member {
    private final String memberId;
    private String name;
    private String email;
    private final BorrowingPolicy policy;
    private List<Book> checkedOutBooks;
    private double finesDue;
    private LocalDate registrationDate;

    public Member(String memberId, String name, String email, BorrowingPolicy policy) {
        this.memberId = Objects.requireNonNull(memberId, "Member ID cannot be null");
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.checkedOutBooks = new ArrayList<>();
        this.finesDue = 0.0;
        this.registrationDate = LocalDate.now();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getMaxBooksAllowed() {
        return policy.getMaxBooksAllowed();
    }

    public boolean canRenew(Book book) {
        return policy.canRenew(book);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", policy=" + policy +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
