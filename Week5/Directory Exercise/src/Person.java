import java.util.Arrays;

import static java.lang.String.format;

/**
(The Person, Student, Employee, Faculty, and Staff classes) Design a class
named Person and its two subclasses named Student and Employee. Make
Faculty and Staff subclasses of Employee. A person has a name, address,
 phone number, and e-mail address. A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant. An employee has an
office, salary, and date hired. Use the MyDate class defined in Programming
        Exercise 10.14 to create an object for date hired. A faculty member has office
hours and a rank. A staff member has a title. Override the toString method in
each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test program
that creates a Person, Student, Employee, Faculty, and Staff, and invokes
their toString() methods.
*/

public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;

    public Person(String name, String address, String phone, String email) {
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

    public String getEmail() {
        return email;
    }

    // Setters for validation (Not currently used but can be used with user input)
    @SuppressWarnings("unused")
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    @SuppressWarnings("unused")
    public void setAddress() {
        if (address != null && !name.trim().isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
    }

    @SuppressWarnings("unused")
    public void setPhone(String phone) {
        // Validation for number formatting
        if (phone != null && phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone cannot be null and must be in the format: xxx-xxx-xxxx");
        }
    }

    @SuppressWarnings("unused")
    public void setEmail(String email) {
        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email format invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("Person[name=%s, address=%s, phone=%s, email=%s]", name, address, phone, email);
    }


    public static void main(String[] args) {
        Person person = new Person("Alice", "123 Berry Ln", "123-456-7890", "123yoohoo@gmail.com");
        Student student = new Student("Zach Lariccia", "123 Berry Ln", "123-456-7890", "123yoohoo@gmail.com", Student.Status.JUNIOR);
        Employee employee = new Employee("Chris Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 65000, System.currentTimeMillis() - 172800000L);
        Faculty faculty = new Faculty("Chris Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 100000000, System.currentTimeMillis() - 172800000L, 5400, "Top");
        Staff staff = new Staff("Zach Lariccia", "123 Berry Ln", "123-456-7890", "124yoohoo@gmail.com", "Rescue 1 Pest Control", 100000000, System.currentTimeMillis() - 172800000L, "CFO");

        // Simplified output using all information
        System.out.println("---------------Person---------------");
        System.out.println(person.toString());
        System.out.println();
        System.out.println("---------------Student---------------");
        System.out.println("-----------Student Statuses----------");
        System.out.println(Arrays.toString(Student.getAllStatuses()));
        System.out.println(student.toString());
        System.out.println();
        System.out.println("---------------Employee---------------");
        System.out.println(employee.toString());
        System.out.println();
        System.out.println("---------------Faculty---------------");
        System.out.println(faculty.toString());
        System.out.println();
        System.out.println("---------------Staff---------------");
        System.out.println(staff.toString());
        System.out.println();



            /* Manually Outputting with getters (Not used but can be for user input)
            System.out.println("---------------Person---------------");
            System.out.println("Name: " + person.getName());
            System.out.println("Address: " + person.getAddress());
            System.out.println("Phone: " + person.getPhone());
            System.out.println("Email: " + person.getEmail());

            System.out.println();
            System.out.println("---------------Student---------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Status: " + student.getStatus());

            System.out.println();
            System.out.println("---------------Employee---------------");
            System.out.println("Name: " + employee.getName());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Phone: " + employee.getPhone());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Office: " + employee.getOffice());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Hire Time (in milliseconds)" + employee.getDateHired());

            System.out.println();
            System.out.println("---------------Faculty---------------");
            System.out.println("Name: " + faculty.getName());
            System.out.println("Address: " + faculty.getAddress());
            System.out.println("Phone: " + faculty.getPhone());
            System.out.println("Email: " + faculty.getEmail());
            System.out.println("Office: " + faculty.getOffice());
            System.out.println("Salary: " + faculty.getSalary());
            System.out.println("Hire Date: " + faculty.getDateHired());
            System.out.println("Office Hours: " + faculty.getOfficeHours());
            System.out.println("Rank: " + faculty.getRank());

            System.out.println();
            System.out.println("---------------Staff---------------");
            System.out.println("Name: " + staff.getName());
            System.out.println("Address: " + staff.getAddress());
            System.out.println("Phone: " + staff.getPhone());
            System.out.println("Email: " + staff.getEmail());
            System.out.println("Office: " + staff.getOffice());
            System.out.println("Salary: " + staff.getSalary());
            System.out.println("Hire Date: " + staff.getDateHired());
            */
    }
}