package cracking.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
//        int[] arr = {-1, 2, 5, 8};
//        int sum = 7;
//        int[] arr = {-3, -1, 0, 2, 6};
//        int sum = 6;
//        int[] arr = {2, 4, 5};
//        int sum = 8;
        int[] arr = {-2, -1, 1, 2};
        int sum = 0;
//        int[] res = new TwoNumbersAsSumOfTwoFromArray().findTwoNumbersAsSumWithHashSet(arr, sum);
//        int[] res = new TwoSum().findTwoNumbersAsSumWithTwoPointers(arr, sum);
        int[] res = new TwoSum().findTwoNumbersAsSumWithBinarySearch(arr, sum);
        System.out.println(Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    private int[] findTwoNumbersAsSumWithBinarySearch(int[] arr, int sum) {
        for (int i = 0; i < arr.length; ++i) {
            int findToSearch = sum - arr[i];
            int s = i + 1, e = arr.length - 1;
            while (s <= e) {
                int mid = s + (e - s)/2;
                if (findToSearch == arr[mid]) {
                    return new int[] {arr[i], arr[mid]};
                } else if(findToSearch < arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return new int[0];
    }

    private int[] findTwoNumbersAsSumWithTwoPointers(int[] arr, int sum) {
        Arrays.stream(arr).sorted().toArray();
        int s = 0, e = arr.length-1;
        while (s < e) {
            if (arr[s] + arr[e] == sum) {
                return new int[] {arr[s], arr[e]};
            } else if (arr[s] + arr[e] > sum) {
                --e;
            } else {
                ++s;
            }
        }
        return new int[0];
    }

    private int[] findTwoNumbersAsSumWithHashSet(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            if(set.contains(sum - arr[i])) {
                return new int[] {arr[i], sum - arr[i]};
            }
            set.add(arr[i]);
        }
        return new int[0];
    }
}
