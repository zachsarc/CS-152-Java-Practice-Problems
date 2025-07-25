import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetMethods {
    public static void main(String[] args) {

        // Append Element to HashSet
        HashSet<String> s = new HashSet<>();
        s.add("Green");
        s.add("Blue");
        s.add("Red");
        System.out.println("Base Set Includes Elements: " + s);

        // Iterating over HashSet
        System.out.println();
        Iterator<String> iterator = s.iterator();
        System.out.println("Iterating over elements we get: ");
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
        System.out.println();

        // Size of HashSet
        System.out.println("The current HashSet contains " + s.size() +  " elements");
        System.out.println();

        // Clear HashSet
        s.clear();
        System.out.println("The current HashSet has just been cleared...");
        System.out.println("The current HashSet contains " + s.size() +  " elements");
        System.out.println();

        // Check if HashSet is Empty
        if(s.isEmpty()) {
            System.out.println("Hashset is confirmed to be empty");
        } else {
            System.out.println("Hashset is confirmed to have elements at this time");
        }
        System.out.println();

        // Adding elements back to HashSet
        s.add("Green");
        s.add("Blue");
        s.add("Red");
        System.out.println("Set  'S' Includes Elements: " + s);
        System.out.println();

        // Cloning HashSet
        HashSet b = new HashSet<>();
        b = (HashSet)s.clone();
        System.out.println("Cloned HashSet b's elements are " + b);
        System.out.println();

        // Convert HashSet to Array
        String[] newArr = new String[b.size()];
        b.toArray(newArr);
        System.out.println("Set b converted to an Array: " + b);
        System.out.println();

        // Converting HashSet to TreeSet
        Set<String> sHashToTree = new TreeSet<>(s);
        System.out.println("Converted 's' set from HashSet to TreeSet, elements: " + s);
        System.out.println();

        // Creating a new TreeSet
        Set<String> cTree = new TreeSet<>();
        cTree.add("Violet");
        cTree.add("Aqua");
        cTree.add("Grey");
        cTree.add("Blue");
        System.out.println("Created a new 'c' TreeSet, elements: " + cTree);

        // Comparing 2 TreeSets
        if (sHashToTree.equals(cTree)) {
            System.out.println("Both the 's' and 'c' TreeSets are equal!");
        } else {
            System.out.println("'c' : " + cTree + "    |    " + "'s' : " + sHashToTree);
            System.out.println("Both the 's' and 'c' TreeSets are NOT equal!");
        }

        // Retaining elements from another set
        System.out.println();
        cTree.retainAll(sHashToTree);
        System.out.println("'c' set retained only the elements in 's' set");
        System.out.println("Updated 'c' TreeSet: " + cTree);

        // Displaying specs of each set after modification
        System.out.println();
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "s", 3);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "c", 1);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "b", 3);
        System.out.printf("Available Set: %-5s | # of Elements: %d%n", "s Tree", 3);
    }
}
