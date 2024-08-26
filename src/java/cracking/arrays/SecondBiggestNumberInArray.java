package cracking.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondBiggestNumberInArray {

    public static void main(String[] args) {
//        int [] arr = new int[]{1};
//        int res =  new SecondBiggestNumberInArray().find(arr);
//        System.out.println(res);

//        int [] arr = new int[]{10,40,20,60,30};
//        int[] res = new SecondBiggestNumberInArray().find(arr, 59);
//        System.out.println(Optional.ofNullable(res[0]).orElse(0) + ":" + Optional.ofNullable(res[1]).orElse(0));

        Map<Integer, Long> map = List.of(1,4,5,2,1,5,3,3,3).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    private int find(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int first = 0;
        int second = 0;
        if (arr[0] >= arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            int it = arr[i];
            if (it > first) {
                int temp = first;
                first = it;
                second = temp;
            } else if (it > second) {
                second = it;
            }
        }
        return second;
    }

    private int[] find(int[] arrNotSorted, int target) {
        int[] res = new int[2];
        int[] arr = Arrays.stream(arrNotSorted).sorted().toArray();
        for (int f = 0, l = arr.length-1; f <= l;) {
            int fV = arr[f];
            int lV = arr[l];
            int sum = fV + lV;
            if (sum == target) {
                res[0] = fV;
                res[1] = lV;
                return res;
            } else if(sum < target) {
                res[0] = fV;
                res[1] = lV;
                f++;
            } else {
                l--;
            }
        }
        return res;
    }
 }
