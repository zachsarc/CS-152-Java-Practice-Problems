import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your sentence (or paragraph), where you want redundancies removed: ");
        String s = sc.nextLine();
        removeRedundant(s);
        sc.close();

    }

    public static void removeRedundant(String s) {
        Set<String> tree = new TreeSet<>();
        String[] myArr = s.split("[,\\.\\s]+");
        for (String word : myArr) {
            if (!word.isEmpty()) {
                tree.add(word.toLowerCase());
            }
        }
        Iterator<String> value = tree.iterator();
        System.out.println("Unique Words in lexicographical order: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }
}

// Test Phrase with redundant words: apple banana orange apple grape banana