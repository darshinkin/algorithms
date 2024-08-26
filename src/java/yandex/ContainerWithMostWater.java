package yandex;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = new ContainerWithMostWater().maxArea(ints);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int result = 0;

        while (s <= e) {
            // System.out.println("s: " + s + "; e: " + e);
            int l = e - s;
            int h = Math.min(height[s], height[e]);
            int sq = l*h;
            result = Math.max(result, sq);
            // System.out.println("Sqare: " + sq);
            if(height[s] > height[e]) {
                e--;
            } else {
                s++;
            }
        }
        return result;
    }
}
