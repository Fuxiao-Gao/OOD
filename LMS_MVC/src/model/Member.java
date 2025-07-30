package model;
import java.util.*;

public class Member {
    public enum MemberType {
        STUDENT(5), FACULTY(10);

        private final int maxBooks;
        // enum constructors are by default private
        MemberType(int maxBooks) {
            this.maxBooks = maxBooks;
        }

        public int getMaxBooksAllowed() {
            return maxBooks;
        }
    }

    private String memberId;
    private String name;
    private String email;
    private MemberType memberType;
    private List<Book> checkedOutBooks;
    private double finesDue;
    private Date registrationDate;

    public Member(String memberId, String name, String email, MemberType memberType) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.memberType = memberType;
        this.checkedOutBooks = new ArrayList<>();
        this.finesDue = 0.0;
        this.registrationDate = new Date(); // default to now
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

    public MemberType getMemberType() {
        return memberType;
    }

    public int getMaxBooksAllowed() {
        return memberType.getMaxBooksAllowed();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", memberType=" + memberType +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
