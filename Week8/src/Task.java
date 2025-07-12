// this class sets up for TaskSchedulerPriorityQueue.java
public class Task implements Comparable<Task>{
    private String name;
    private int priority;
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + " (priority: " + priority + ")";
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
