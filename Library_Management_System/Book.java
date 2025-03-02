import java.util.Date;

public class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private String Author;
    private Date publicationDate;
    private int numberOfPages;

    public Book(String ISBN, String title, String subject, String publisher, String language, String Author, Date publicationDate, int numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.Author = Author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

}
