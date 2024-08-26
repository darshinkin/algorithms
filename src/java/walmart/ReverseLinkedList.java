package walmart;

public class ReverseLinkedList {

    static class Node {
        Character value;
        Node nextNode;

        public Node(Character value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    public static void main(String[] args) {
        Node nodeD = new Node('d', null);
        Node nodeC = new Node('c', nodeD);
        Node nodeB = new Node('b', nodeC);
        Node nodeA = new Node('a', nodeB);
        printList(nodeA);
        Node result = new ReverseLinkedList().reverse(nodeA);
        printList(result);
    }

    private static void printList(Node result) {
        while (true) {
            System.out.print(result.value + " -> ");
            result = result.nextNode;
            if (result == null) {
                System.out.println("null");
                break;
            }
        }
    }

    private Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        Node next;
        while (true) {
            next = current.nextNode;
            current.nextNode = previous;
            if (next == null) {
                break;
            }
            previous = current;
            current = next;
        }

        return current;
    }
}
