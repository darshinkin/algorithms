package walmart;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class ArrayKthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {2,45,32,67,123};
        int k = 2;
//        int res = new ArrayKthSmallestElement().findWithTreeSet(arr, k);
        int res = new ArrayKthSmallestElement().findWithPriorityQueue(arr, k);
        System.out.println(res);
    }

    private int findWithPriorityQueue(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i = 0; i < arr.length; ++i) {
            queue.add(arr[i]);
        }
        System.out.println(queue);
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }
        System.out.println(queue);
        return queue.peek();
    }

    private int findWithTreeSet(int[] arr, int k) {
        if (arr.length < k || k < 1) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < arr.length; ++i) {
            set.add(arr[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < k-1; i++) {
            iterator.next();
        }
        return iterator.next();
    }
}
