package stepic.greedy;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyKnapsack {

    class Item implements Comparable<Item> {
        int weight;
        int cost;

        public Item(int cost, int weight) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public int compareTo(Item o) {
            long r1 = (long) cost * o.weight;
            long r2 = (long) o.cost * weight;
            return -Long.compare(r1, r2);
            /*double r1 = (double) cost/weight;
            double r2 = (double) o.cost/o.weight;
            return -Double.compare(r1, r2);*/
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", cost=" + cost +
                    '}';
        }
    }

    private void run() throws FileNotFoundException {
//        Scanner input = new Scanner(new File("greedyknapsack.txt"));
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int W = input.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        Arrays.sort(items);

//        Arrays.stream(items).forEach(item -> System.out.println(item + ". Relation: " + (double)item.cost/item.weight));

        double result = 0;
        for (Item item : items) {
            if (item.weight <= W) {
                result += item.cost;
                W -= item.weight;
            } else {
                result += (double) item.cost * W /item.weight;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new GreedyKnapsack().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
