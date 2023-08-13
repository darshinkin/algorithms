package cracking.arrays;

import java.util.HashSet;
import java.util.Set;

public class MostPositiveIntegerInArray {

    public static void main(String[] args) {
//        int [] array = new int[] {3,5,7,1,9};
//        int [] array = new int[] {1,2,3,4};
//        int [] array = new int[] {1,2,-3,4};
        int [] array = new int[] {-1,-2,-3,-4};
        int res = new MostPositiveIntegerInArray().solutions(array);
        System.out.println("Result: " + res);
    }

    private int solutions(int[] array) {
        Set<Integer> set = new HashSet<>();
        int min = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            min = Math.min(min, item);
            max = Math.max(max, item);
            set.add(item);
        }
        int m = max;
        for (int i = 0; i < set.size(); i++) {
            int item = max - 1;
            if (item < 0 || item == 0) {
                break;
            }
            if (!set.contains(item)) {
                return item;
            }
            max--;
        }
        if (m > 0) {
            return ++m;
        } else {
            return 1;
        }
    }
}
