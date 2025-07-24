import java.io.File;
import java.io.IOException;
import java.util.*;

public class CountOccurrencesFromFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the absolute directory the text file is in: ");
        String dir = sc.nextLine();
        countOccurrences(dir);
        sc.close();
    }

    public static void countOccurrences(String filePath) {
        Map<String, Integer> mp = new TreeMap<>();
        File userFile = new File(filePath);

        if (!userFile.exists()) {
            System.out.println("File not found at path: " + filePath);
            return;
        }

        try (Scanner fileScanner = new Scanner(userFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+"); // split by 1+ spaces
                    for (String word : words) {
                        String key = word.toLowerCase();
                        if (!key.isEmpty()) {
                            if (!mp.containsKey(key)) {
                                mp.put(key, 1);
                            } else {
                                int value = mp.get(key);
                                value++;
                                mp.put(key, value);
                            }
                        }
                    }
                }
            }

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(mp.entrySet());
            sortedEntries.sort((e1, e2) -> {
                int valueCompare = e2.getValue().compareTo(e1.getValue());
                if (valueCompare == 0) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return valueCompare;
            });
            System.out.println("Word occurrences (most frequent first)");
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}
