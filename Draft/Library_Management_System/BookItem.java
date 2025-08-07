import java.util.Date;

public class BookItem extends Book {
    private String barcode;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private String borrowerId;

    // constructor
    public BookItem(String ISBN, String title, String subject, String publisher, String language, String Author, Date publicationDate, int numberOfPages, String barcode, double price, BookFormat format) {
        super(ISBN, title, subject, publisher, language, Author, publicationDate, numberOfPages);
        this.barcode = barcode;
        this.price = price;
        this.format = format;
        this.status = BookStatus.AVAILABLE;
    }

    public boolean checkout(String memberId) {
        // check out the book to a member if it is available
        if (status == BookStatus.AVAILABLE) {
            status = BookStatus.LOANED;
            borrowed = new Date();
            dueDate = new Date(borrowed.getTime() + 14 * 24 * 60 * 60 * 1000); // 14 days
            borrowerId = memberId;
            return true;
        }
        return false;
    }

    // check if the book is not currently available
    public boolean isNotAvailable() {
        return status != BookStatus.AVAILABLE;
    }
}
