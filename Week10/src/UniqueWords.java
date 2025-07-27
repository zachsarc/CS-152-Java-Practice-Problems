import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your sentence (or paragraph), where you want redundancies removed and frequency counted: ");
        String s = sc.nextLine();
        removeRedundant(s);
        System.out.println();
        frequencyCounter(s);
        sc.close();

    }

    public static void removeRedundant(String s) {
        Set<String> tree = new TreeSet<>();
        String[] myArr = s.split("[,\\.\\s!?:;]+");
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

    public static void frequencyCounter (String s) {
        Map<String, Integer> tree = new TreeMap<>();
        String[] myArr = s.split("[,\\.\\s!?:;]+");
        for (String word : myArr) {
            String key = word.toLowerCase();
            if (!word.isEmpty()) {
                tree.put(word, tree.getOrDefault(key, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(tree.entrySet());
        sorted.sort((c1, c2) -> {
            int valueCompare = c2.getValue().compareTo(c1.getValue());
            if (valueCompare == 0) {
                return c1.getKey().compareTo(c2.getKey());
            }
            return valueCompare;
        });
        System.out.println("Word occurrences");
        for (Map.Entry<String, Integer> entry : sorted) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}

// Test Phrase with redundant words: apple banana orange apple grape banana