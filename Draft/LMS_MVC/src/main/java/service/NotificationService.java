package model;
import model.Book;
import model.Member;

public class NotificationService {
    // send notification when a reserved book becomes available
    public void sendAvailabilityNotification(Book book, Member member) {
        System.out.println("Notification: The book '" + book.getTitle() + "' is now available for checkout.");
        System.out.println("Dear " + member.getName() + ", you can now borrow this book.");
    }
    
    // send notification when a checked-out book is overdue
    public void sendOverdueNotification(Book book, Member member) {
        System.out.println("Notification: The book '" + book.getTitle() + "' is overdue");
        System.out.println("Dear " + member.getName() + ", please return the book as soon as possible to avoid further penalties.");
    }
}
