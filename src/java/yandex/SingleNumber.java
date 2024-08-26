package yandex;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 */

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        int result = new SingleNumber().singleNumber(nums);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int e = nums[0];
        for(int i = 1; i < nums.length; i++) {
            e ^= nums[i];
        }
        return e;
    }

    public int singleNumberWithSet(int[] nums) {
        Set<Integer> map = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if(map.contains(element)) {
                map.remove(element);
            } else {
                map.add(element);
            }
        }
        return map.iterator().next();
    }
}
