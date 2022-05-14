package cracking.collections;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaxNumberOccurredOnce {
    public static void main(String[] args) {
        int[] arr = {5, 7, 3, 9, 4, 9, 8, 3, 1, 3};
//        int[] arr = {9,9,8,8};
        int res = new MaxNumberOccurredOnce().findMaxNumberOccurreOnceMap(arr);
        System.out.println(res);
    }

    private int findMaxNumberOccurreOnceSet(int[] arr) {
        int res = -1;
        if (arr.length == 0) {
            return res;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            if (set.contains(e)) {
                set.remove(e);
            } else {
                set.add(e);
            }
        }
        res = set.stream().max((f,s) -> f-s).orElse(-1);
        System.out.println("Set: " + set);
        return res;
    }

    private int findMaxNumberOccurreOnceMap(int[] arr) {
        int res = -1;
        if (arr.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            map.compute(e, (key, oldValue) -> oldValue == null ? 1 : ++oldValue);
        }
        System.out.println("Map: " + map);
        return map.entrySet().stream()
//                .max(Comparator.comparingInt(Map.Entry::getValue))
                .filter(e -> e.getValue() == 1)
                .max(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}
