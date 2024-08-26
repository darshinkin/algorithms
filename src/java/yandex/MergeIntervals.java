package yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

public class MergeIntervals {

    public static void main(String[] args) {
        int [][] intervals = {{8,10},{1,3},{2,6},{15,18}};
//        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int [][] intervals = {{1,3}};
//        int [][] intervals = {{1,4},{5,6}};
//        int [][] result = new MergeIntervals().solution(intervals);
        System.out.println(Arrays.deepToString(intervals));
        int [][] result = new MergeIntervals().solution2(intervals);
        System.out.println(Arrays.deepToString(result));
    }

    private int[][] solution2(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(intervals, (f, s) -> f[0] - s[0]);
//        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(res.isEmpty() || (res.get(res.size() - 1).get(1) < intervals[i][0])) {
                res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                int max = Math.max(res.get(res.size() - 1).get(1), intervals[i][1]);
                res.get(res.size() - 1).set(1, max);
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }

        return intervals;
    }

    private int[][] solution(int[][] intervals) {
        int l = intervals.length;
        if (l < 2) return intervals;
        int p = 0;
        int ps = intervals[0][0];
        int pe = intervals[0][1];
        for(int i = 1; i < l; i++) {
            int cs = intervals[i][0];
            int ce = intervals[i][1];
            if(pe >= cs) {
                pe = ce;
                continue;
            }
            System.out.println("ps: " + ps + "; pe: " + pe);
            intervals[p][0] = ps;
            intervals[p][1] = pe;
            ps = cs;
            pe = ce;
            p++;
        }
        intervals[p][0] = ps;
        intervals[p][1] = pe;
        int[][] result = new int[p+1][2];
        for(int i = 0; i < p+1; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }
}
