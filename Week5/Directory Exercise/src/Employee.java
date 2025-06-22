public class Employee extends Person {
    private String office;
    private Double salary;
    private MyDate dateHired;

    public Employee(String name, String address, String phone, String email, String office, double salary, long hireTimeInMillis) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new MyDate(hireTimeInMillis);
    }

    // Getters
    public MyDate getDateHired() {
        return dateHired;
    }

    public String getOffice() {
        return office;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString () {
        return String.format("Employee[%s, office=%s, salary=%.2f, dateHired=%s]", super.toString(), office, salary, dateHired.toString());
    }
}
