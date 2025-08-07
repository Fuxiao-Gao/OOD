package model;
import policy.FacultyBorrowingPolicy;

public class Faculty extends Member {
    private final String facultyId;
    private final FacultyBorrowingPolicy borrowingPolicy;

    public Faculty(String memberId, String name, String email, String facultyId) {
        super(memberId, name, email, new FacultyBorrowingPolicy());
        this.borrowingPolicy = new FacultyBorrowingPolicy();
        this.facultyId = facultyId;
    }
    
    public String getFacultyId() {
        return facultyId;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId='" + facultyId + '\'' +
                ", memberId='" + getMemberId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", registrationDate=" + getRegistrationDate() +
                '}';
    }
}
