package stepic.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding {

    class Node implements Comparable<Node>{
        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(sum, node.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    class ListNode extends Node {
        char symbol;

        public ListNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + " " + code);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HuffmanCoding().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("huffman.txt"));
        String s = input.next();
//        System.out.println(s);
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                count.put(c, count.get(c)+1);
            }
        }
        /*for (Map.Entry<Character, Integer> ch : count.entrySet()) {
            System.out.println(ch.getKey() + ":" + ch.getValue());
        }*/

        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            ListNode node = new ListNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            priorityQueue.add(node);
        }

//        priorityQueue.stream().forEach(System.out::print);

        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        if (count.size() == 1) {
            sum = s.length();
        }

        System.out.println(count.size() + " " + sum);

        Node root = priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(charNodes.get(c).code);
        }
        System.out.println(stringBuilder.toString());

        //abacabad
    }
}
