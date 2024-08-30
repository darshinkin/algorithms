package yandex;

import java.util.Arrays;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation:
 * Window position                Median
 * ---------------                -----
 * [1  3  -1] -3  5  3  6  7        1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7        3
 *  1  3  -1  -3 [5  3  6] 7        5
 *  1  3  -1  -3  5 [3  6  7]       6
 * Example 2:
 *
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 */

public class SlidingWindowMedian {

    public static void main(String[] args) {
//        int[] arr = {1,3,-1,-3,5,3,6,7};
//        int[] arr = {1,4,2,3};
        int[] arr = {2147483647,
                     2147483647};
        double[] result = new SlidingWindowMedian().medianSlidingWindow(arr, 2);
        System.out.println(Arrays.toString(result));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        boolean even = k%2 == 0;
        int[] temp = new int[k];
        for (int i = 0; i <= nums.length-k; i++) {
            for(int j = 0; j < k; ++j) {
                temp[j] = nums[i+j];
            }
            System.out.println("temp: " + Arrays.toString(temp));
            Arrays.sort(temp);
            System.out.println("temp sorted: " + Arrays.toString(temp));
            double mediana;
            if(!even) {
                int index = k/2;
                mediana = temp[index];
                System.out.println("index: " + index + "; mediana: " + mediana);
            } else {
                int i1 = k/2 - 1;
                int i2 = k/2;
                int el1 = temp[i1];
                int el2 = temp[i2];
                long sum = el1 - el2;
                mediana = sum /2.0;
                System.out.println("num1: "+temp[i1]+"; num2: "+temp[i2]);
                System.out.println("i1: "+i1+"; i2: "+i2+"; mediana: "+mediana);
            }
            result[i] = mediana;
        }
        return result;
    }
}
