public class Faculty extends Employee {
    int officeHours;
    String rank;

    public Faculty(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis, int officeHours, String rank) {
        super(name, address, phone, email, office, salary, hireTimeInMillis);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public int getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Class - Faculty -- " + "Name: " + getName();
    }
}
