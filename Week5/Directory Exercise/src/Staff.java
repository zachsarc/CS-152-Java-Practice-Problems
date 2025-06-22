public class Staff extends Employee {
    String title;

    public Staff(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis) {
        super(name, address, phone, email, office, salary, hireTimeInMillis);
        this.title = title;
        }

    @Override
    public String toString() {
        return "Class - Staff -- " + "Name: " + getName();
    }
}
