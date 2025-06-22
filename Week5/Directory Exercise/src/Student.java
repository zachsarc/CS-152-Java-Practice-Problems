public class Student extends Person {
    public enum Status {
        FRESHMAN,
        SOPHOMORE,
        JUNIOR,
        SENIOR
    }

    private Status status;

    public Student (String name, String address, String phone, String email, Status status) {
        super(name, address, phone, email);
            this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Status[] getAllStatuses() {
        return Status.values();
    }

    @Override
    public String toString () {
        return String.format("Student[%s, status=%s]", super.toString(), status);
    }
}
