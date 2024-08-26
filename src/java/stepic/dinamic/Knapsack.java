package stepic.dinamic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        new Knapsack().run();
    }

    public void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("src/java/stepic/dinamic/knapsack.txt"));
        int needed = Integer.parseInt(input.readLine());
        String w = input.readLine();
        String c = input.readLine();
        String [] weightsStr = w.split(" ");
        String[] coastStr = c.split(" ");
        int[] weigths = Arrays.stream(weightsStr).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(weigths).forEach(i -> System.out.print(i + " "));
        System.out.println();
        int[] coasts = Arrays.stream(coastStr).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(coasts).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println(knapsack(weigths, coasts, needed));
    }

    int knapsack(int weights[], int costs[], int needed) {
        int n = weights.length;
        int dp[][] = new int[needed + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weights[j-1] <= w) {
                    dp[w ][j] = Math.max(dp[w][j - 1], dp[w - weights[j-1]][j - 1] + costs[j-1]);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }
        return dp[needed][n];
    }
}
