package stepic.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("binarysearch.txt"));
        int n = input.nextInt();
        int [] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = input.nextInt();
        }
        int k = input.nextInt();
        int [] m = new int[k];
        for (int i = 0; i < k; i++) {
            m[i] = input.nextInt();
        }

        Map<Integer, Integer> doubles = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i<m.length; i++) {
            int e = m[i];
            int j;
            if (doubles.containsKey(e)) {
                j = doubles.get(e);
            } else {
                j = searchSrc(e, src);
                doubles.put(e, j);
            }
            list.add(j);
        }

        list.stream().forEach(e -> System.out.print(e + " "));
    }

    private int searchSrc(int e, int[] src) {
        int l = 0;
        int r = src.length -1;
        while (l <= r) {
            int m = l + ((r-l)/2);
            int i = src[m];
            if (i == e) {
                return ++m;
            } else if (i > e) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
