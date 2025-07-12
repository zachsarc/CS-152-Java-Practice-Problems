import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedulerPriorityQueue {
    public static void main(String[] args) {
        List<Task> lt = new ArrayList<>();
        Task task1 = new Task("Feed the dog", 1);
        Task task2 = new Task("Put away laundry", 3);
        Task task3 = new Task("Feed myself", 2);
        lt.add(task3);
        lt.add(task1);
        lt.add(task2);

        scheduleTasks(lt);

    }

    public static void scheduleTasks(List<Task> tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        pq.addAll(tasks);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
