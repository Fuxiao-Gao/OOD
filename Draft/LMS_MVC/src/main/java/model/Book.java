package model;
import java.time.LocalDate;

public class Book {
    public enum BookStatus {
        AVAILABLE, CHECKED_OUT, RESERVED, OVERDUE
    }

    public enum BookType {
        FICTION, NON_FICTION, REFERENCE, EBOOK
    }

    private String isbn;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String barcode;
    private BookStatus status; 
    private BookType type;

    public Book(String isbn, String title, String author, LocalDate publicationDate, String barcode, BookStatus status, BookType type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.barcode = barcode;
        this.status = status;
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public BookStatus getStatus() {
        return status;
    }

    public BookType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", barcode='" + barcode + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}