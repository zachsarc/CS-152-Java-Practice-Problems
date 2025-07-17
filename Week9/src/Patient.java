public class Patient implements Comparable<Patient>{

    private String name;
    private int severity;
    private int arrivalOrder;

    public Patient(String name, int severity, int arrivalOrder) {
        this.name = name;
        this.severity = severity;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    @Override
    public int compareTo(Patient other) {
        int severityCmp = Integer.compare(this.severity, other.severity);
        return (severityCmp != 0) ? severityCmp : Integer.compare(this.arrivalOrder, other.arrivalOrder);
    }
}
