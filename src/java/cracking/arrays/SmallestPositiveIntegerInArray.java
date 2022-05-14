package cracking.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class SmallestPositiveIntegerInArray {

    public static void main(String[] args) {
        int[] arr =  {1, 3, 6, 4, 1, 2};
//        int[] arr =  {1, 2, 3};
//        int[] arr =  {-1, -3};
        int res = findSmallestPositiveIntegerInArrayWithSorting(arr);
        System.out.println(res);
    }

    private static int findSmallestPositiveIntegerInArrayWithSorting(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        List<Integer> integers = Arrays.stream(A).sorted().boxed().collect(Collectors.toList());
        if (integers.get(integers.size() - 1) < 1) {
            return 1;
        }
        int previous = integers.get(integers.size()-1);
        for (int i = integers.size()-2; i >= 0; i--) {
            int current = integers.get(i);
            if ((previous - current) > 1) {
                return --previous;
            }
            previous = current;
        }
        return integers.get(integers.size() - 1) + 1;
    }

    /*private static int findSmallestPositiveIntegerInArray(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            set.add(cur);
            if (set.contains(A[cur-1]))
        }
    }*/
}
