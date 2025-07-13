import java.util.*;

public class SortStudentsGpaPriorityQueue {
    public static void main(String[] args) {
        List<Student> lt = new ArrayList<>();
        Student s2 = new Student("Lindsay", 0);
        Student s1 = new Student("Liam", 0);
        Student s3 = new Student("Zach", 0);
        Student s4 = new Student("Jocy", 0);

        // Using the setGpa() setter method to ensure robust exception handling
        s2.setGpa(3.70);
        s1.setGpa(3.67);
        s3.setGpa(4.0);
        s4.setGpa(4.0);

        lt.add(s1);
        lt.add(s2);
        lt.add(s3);
        lt.add(s4);

        processStudents(lt);
    }

    public static void processStudents(List<Student> students) {
        PriorityQueue<Student> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getGpa(), a.getGpa()));
        pq.addAll(students);

        while (!pq.isEmpty()) {
            Student student = pq.poll();
            System.out.println(student.getName() + ": " + student.getGpa());
        }
    }
}
