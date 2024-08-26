package yandex;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {-1,0,3,5,9,12};
//        int target = 2;
        int[] arr = {1};
        int target = 0;
        int res = new BinarySearch().search(arr, target);
        System.out.println(res);

//        Map<Integer, Integer> map = new HashMap();
//        char[] chars = "lll".toCharArray();
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < nums.length; i++) {
//            int element = nums[i];
//            if(map.contains(target - element)) {
//                return new int[] {i, map.get(target - element)};
//            }
//            map.put(element, i);
//        }
//        return null;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int middle = (end - start)/2 + start;
            int e = nums[middle];
            System.out.println("middle: index: " + middle + ", element: " + e);
            if(e == target) {
                return middle;
            } else if(e < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
