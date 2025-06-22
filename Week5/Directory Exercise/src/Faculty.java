public class Faculty extends Employee {
    private int officeHours;
    private String rank;

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
    public String toString () {
        return String.format("Faculty[%s, officeHours=%s, rank=%s]", super.toString(), officeHours, rank);
    }
}
