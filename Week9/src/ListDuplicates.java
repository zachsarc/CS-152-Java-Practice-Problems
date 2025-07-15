/* NOTE: Sorting with Comparator is not for practical reasons (i.e. not preserve the original order), however,
I wanted to try and implement it somehow into this code.
 */

import java.util.*;

public class ListDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(3);
        System.out.println("The original list is " + removeDuplicates(list));
    }

    public static List<Integer> removeDuplicates(List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> alreadySeenSet = new HashSet<>();

        for (Integer n : nums) {
            list.add(n);
            alreadySeenSet.add(n);
        }
        System.out.println("The set with no duplicates is " + alreadySeenSet);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
