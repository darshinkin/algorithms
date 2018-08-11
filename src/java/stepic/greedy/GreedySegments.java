package stepic.greedy;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GreedySegments {

    class Segment implements Comparable<Segment> {
        int left;
        int right;

        public Segment(int s, int f) {
            this.left = s;
            this.right = f;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int compareTo(Segment segmet) {
            if (right <= segmet.right) {
                return -1;
            }
            return 1;
        }

        public boolean contains(int p) {
            return left <= p && p <= right;
        }
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Segment[] segmets = new Segment[n];
        for (int i = 0; i < n; i++) {
            segmets[i] = new Segment(input.nextInt(), input.nextInt());
        }
        Arrays.sort(segmets);

        /*Stream<Segment> segmetStream = Arrays.stream(segmets);
        segmetStream.forEach(System.out::println);*/

        List<Integer> res = new LinkedList<>();

        Segment s = segmets[0];
        int p = s.right;
        res.add(p);
        for (int i = 1; i < n; i++) {
            Segment segmet = segmets[i];
            if (segmet.contains(p)) {
                continue;
            } else {
                p = segmet.right;
                res.add(p);
            }
        }
        System.out.println(res.size());
        res.stream().forEach(result -> System.out.print(result + " "));
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new GreedySegments().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
