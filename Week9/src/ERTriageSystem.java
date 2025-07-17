// A program to simulate an Emergency Room Triage System

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ERTriageSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Bob Kodiak", 3, 1);
        Patient p2 = new Patient("Don Kodiak", 1, 2);
        Patient p3 = new Patient("Patty Zimmerman", 2, 3);
        List<Patient> patients = new ArrayList<>();
        patients.add(p1);
        patients.add(p2);
        patients.add(p3);


        processPatients(patients);
    }

    public static void processPatients(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>();

        System.out.println("--------------------Patient List--------------------");
        for (Patient p : patients) {
          pq.add(p);
          System.out.println("Patient Name: " + p.getName() + "    Severity: " + p.getSeverity() + "    Arrival Place: " + p.getArrivalOrder());
        }
        System.out.println("----------------------------------------------------");
        System.out.println();
            while (!pq.isEmpty()) {
                Patient currentPatient = pq.poll();
                System.out.println("Currently treating: " + currentPatient.getName() + " (Severity: " + currentPatient.getSeverity() + ", Arrival Order: " + currentPatient.getArrivalOrder() + ")");
            }
    }
}
