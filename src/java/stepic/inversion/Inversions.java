package stepic.inversion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Inversions {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Inversions().run();
        long finishTime = System.currentTimeMillis();
//        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws IOException {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader input = new BufferedReader(new FileReader("inversions.txt"));
        int n = Integer.parseInt(input.readLine());
        int[] a = new int[n];
        String[] tokens = input.readLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }
        mergeSortA(a);
        System.out.println(count);
    }

    private int[] mergeSortA(int[] a) {
        if (a.length == 1) {
            return a;
        }
        int m = a.length/2;
        int[] l = new int[m];
        int[] r = new int[a.length - m];
        System.arraycopy(a, 0, l, 0, m);
        System.arraycopy(a, m, r, 0, a.length-m);
        l = mergeSortA(l);
        r = mergeSortA(r);
        return merge(l, r);
    }

    long count = 0;

    private int[] merge(int[] a, int[] b) {
        int[] k = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        for (int l = 0; l < k.length; l++) {
            if ((j == b.length) || i<a.length && a[i] <= b[j]) {
                k[l] = a[i];
                ++i;
            } else {
                count += (a.length-i);
                k[l] = b[j];
                ++j;
            }
        }
        return k;
    }
}
