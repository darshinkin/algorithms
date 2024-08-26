package stepic.greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MaxTerm {
    public static void main(String[] args) {
        new MaxTerm().run();
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        List<Integer> res = new LinkedList<>();
        int count = n;
        for (int i = 1; i <= count; i++) {
            n -= i;
            if (n < 0) {
                ((LinkedList<Integer>) res).removeLast();
                res.add(i);
                break;
            } else {
                res.add(i);
            }
            if (n == 0) {
                break;
            }
        }

        System.out.println(res.size());
        res.forEach(i -> System.out.print(i + " "));
    }
}
