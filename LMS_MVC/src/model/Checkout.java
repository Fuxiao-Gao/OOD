package model;
import java.time.LocalDate;

public class Checkout {
    public enum CheckoutStatus {
        CHECKED_OUT,
        RETURNED,
        OVERDUE
    }

    private Book book;
    private Member member;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private CheckoutStatus status;

    public Checkout(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.checkoutDate = LocalDate.now();
        this.dueDate = checkoutDate.plusWeeks(2); // default due date is 2 weeks from checkout
        this.status = CheckoutStatus.CHECKED_OUT;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public CheckoutStatus getStatus() {
        return status;
    }

    public void setStatus(CheckoutStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "book=" + book.getTitle() +
                ", member=" + member.getName() +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" +  dueDate +
                ", status=" + status +
                '}';
    }    
}
