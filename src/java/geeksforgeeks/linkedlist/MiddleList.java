package geeksforgeeks.linkedlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MiddleList {

    Node head;

    class Node {
        Node next;
        String data;

        public Node(String data) {
            this.next = null;
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        new MiddleList().run();
    }

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("src/java/geeksforgeeks/linkedlist/middlelist.txt"));
        String str = input.readLine();
        String[] strings = str.split("->");
        for (int i = 0; i < strings.length; i++) {
            Node node = new Node(strings[i]);
            node.next = head;
            head = node;
        }

        Node node = head;
        while(node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();

        Node slow = head;
        Node fast = head;
        if (head != null) {
            while(slow != null && fast != null) {
                if (fast.next == null) {
                    break;
                } else {
                    fast = fast.next.next;
                }
                slow = slow.next;
            }
            System.out.println(slow.data);
        }
    }
}
