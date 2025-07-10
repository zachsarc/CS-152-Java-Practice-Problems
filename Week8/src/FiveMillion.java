/*
(Use iterators on linked lists) Write a test program that stores 5 million integers
in a linked list and test the time to traverse the list using an iterator vs. using
the get(index) method.
*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class FiveMillion {
    public static void main(String[] args) {
        //linkedGen(5000000);
        linkedGen(5000000);
    }

    public static void linkedGen(int size) {
        LinkedList<Integer> fiveMil = new LinkedList<>();
        Random randomNum = new Random();
        // Populate linked list
        for (int i = 0; i < size; i++) {
            int r = randomNum.nextInt(size); // Limited the random number for data size allocation purposes
            fiveMil.add(r);
        }
        // Begin process speed timer for iterator
        long startTimer = System.nanoTime();
        Iterator<Integer> it = fiveMil.iterator();
        while (it.hasNext()) {
            it.next();
        }
        long endTimer = System.nanoTime();
        long resultNs = endTimer - startTimer;
        long resultMs = resultNs / 1_000_000;

        // Print computed process speed and display it in ms
        System.out.println();
        System.out.println("Finished...");
        System.out.println("Iterator process time: " + resultMs + "ms");
        System.out.println("The current size of the linked list is " + fiveMil.size());
        System.out.println();


        // Method 2
        startTimer = System.nanoTime();
        for (int i = 0; i < fiveMil.size(); i++) {
            fiveMil.get(i);
        }
        endTimer = System.nanoTime();
        resultNs = endTimer - startTimer;
        resultMs = resultNs / 1_000_000;
        System.out.println("get(index) process time: " + resultMs + "ms");
        System.out.println("The current size of the linked list is " + fiveMil.size());
    }
}

/* Note
The whole purpose of this exercise is to show how inefficient indexing linked lists actually are;
while using the implemented iterator is superior for linked lists
 */