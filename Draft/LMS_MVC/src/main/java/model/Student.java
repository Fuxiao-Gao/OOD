package model;
import policy.StudentBorrowingPolicy;

public class Student extends Member {
    private final String studentId;
    private final StudentBorrowingPolicy policy;

    public Student(String memberId, String name, String email, String studentId) {
        super(memberId, name, email, new StudentBorrowingPolicy());
        this.policy = new StudentBorrowingPolicy();
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", memberId='" + getMemberId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", registrationDate=" + getRegistrationDate() +
                '}';
    }
}
