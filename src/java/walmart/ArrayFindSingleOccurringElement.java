package walmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayFindSingleOccurringElement {

    public static void main(String[] args) {
        int[] arr = {3,1,5,1,7,3,5};
//        int[] arr = {5,1,5};
//        int[] arr = {5};
//        int res = new ArrayFindSingleOccurringElement().find(arr);
        int res = new ArrayFindSingleOccurringElement().findWithAuxiliaryCollection(arr);
        System.out.println(res);
    }

    private int findWithAuxiliaryCollection(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int el = arr[i];
            if (!set.contains(el)) {
                set.add(el);
            } else {
                set.remove(el);
            }
        }
        return set.iterator().next();
    }

    private int find(int[] arr) {
        if (arr.length < 2) {
            return arr[0];
        }
        Arrays.sort(arr);
        for (int i = 0, j = 1; i < arr.length; i = i+2, j = j+2) {
            if (arr.length == j) {
                return arr[i];
            }
            if (arr[i] != arr[j]) {
                return arr[i];
            }
        }
        return 0;
    }
}
