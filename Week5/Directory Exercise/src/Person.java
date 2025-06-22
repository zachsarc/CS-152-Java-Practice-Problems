/**
(The Person, Student, Employee, Faculty, and Staff classes) Design a class
named Person and its two subclasses named Student and Employee. Make
Faculty and Staff subclasses of Employee. A person has a name, address,
 phone number, and e-mail address. A student has a class status (freshman, soph-
 omore, junior, or senior). Define the status as a constant. An employee has an
office, salary, and date hired. Use the MyDate class defined in Programming
        Exercise 10.14 to create an object for date hired. A faculty member has office
hours and a rank. A staff member has a title. Override the toString method in
each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test program
that creates a Person, Student, Employee, Faculty, and Staff, and invokes
their toString() methods.
*/

public class Person {
    String name;
    String address;
    String phone;
    String email;

    public Person (String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getemail() {
        return email;
    }


public static void main(String[] args){
        Person person = new Person("Alice", "123 Berry Ln", "123-456-7890", "123yoohoo@gmail.com");
        Student student = new Student("Zach Lariccia", "123 Berry Ln", "123-456-7890","123yoohoo@gmail.com");
        Employee employee = new Employee("Chris Lariccia" ,"123 Berry Ln","123-456-7890","124yoohoo@gmail.com","Rescue 1 Pest Control",65000,System.currentTimeMillis() - 172800000L);
        Faculty faculty = new Faculty("Chris Lariccia" ,"123 Berry Ln","123-456-7890","124yoohoo@gmail.com","Rescue 1 Pest Control",100000000,System.currentTimeMillis() - 172800000L, 5400,"CEO");
        Staff staff = new Staff("Zach Lariccia" ,"123 Berry Ln","123-456-7890","124yoohoo@gmail.com","Rescue 1 Pest Control",100000000,System.currentTimeMillis() - 172800000L);
        System.out.println("Person");
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Phone: " + person.getPhone());
        System.out.println("Email: " + person.getemail());

    System.out.println();
    System.out.println("Student");
    System.out.println("Name: " + student.getName());
    System.out.println("Address: " + student.getAddress());
    System.out.println("Phone: " + student.getPhone());
    System.out.println("Email: " + student.getemail());

    System.out.println();
    System.out.println("Employee");
    System.out.println("Name: " + employee.getName());
    System.out.println("Address: " + employee.getAddress());
    System.out.println("Phone: " + employee.getPhone());
    System.out.println("Email: " + employee.getemail());
    System.out.println("Office: " + employee.getOffice());
    System.out.println("Salary: " + employee.getSalary());
    System.out.println("Hire Time (in milliseconds)" + employee.getDateHired());

    System.out.println();
    System.out.println("Faculty");
    System.out.println("Name: " + faculty.getName());
    System.out.println("Address: " + faculty.getAddress());
    System.out.println("Phone: " + faculty.getPhone());
    System.out.println("Email: " + faculty.getemail());
    System.out.println("Office: " + faculty.getOffice());
    System.out.println("Salary: " + faculty.getSalary());
    System.out.println("Hire Date: " + faculty.getDateHired());
    System.out.println("Office Hours: " + faculty.getOfficeHours());
    System.out.println("Rank: " + faculty.getRank());

    System.out.println();
    System.out.println("Staff");
    System.out.println("Name: " + staff.getName());
    System.out.println("Address: " + faculty.getAddress());
    System.out.println("Phone: " + faculty.getPhone());
    System.out.println("Email: " + faculty.getemail());
    System.out.println("Office: " + faculty.getOffice());
    System.out.println("Salary: " + faculty.getSalary());
    System.out.println("Hire Date: " + faculty.getDateHired());
    System.out.println("Office Hours: " + faculty.getOfficeHours());
    System.out.println("Rank: " + faculty.getRank());
    }
}
