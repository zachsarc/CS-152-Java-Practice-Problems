public class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis, String title) {
        super(name, address, phone, email, office, salary, hireTimeInMillis);
        this.title = title;
        }

        public String getTitle() {
        return title;
        }

    @Override
    public String toString () {
        return String.format("Staff[%s, title=%s]", super.toString(), title);
    }
}
