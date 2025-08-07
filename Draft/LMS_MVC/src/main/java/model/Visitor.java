package model;
import policy.VisitorBorrowingPolicy;

public class Visitor extends Member {
    private final VisitorBorrowingPolicy borrowingPolicy;

    public Visitor(String memberId, String name, String email) {
        super(memberId, name, email, new VisitorBorrowingPolicy());
        this.borrowingPolicy = new VisitorBorrowingPolicy();
    }

    
}
