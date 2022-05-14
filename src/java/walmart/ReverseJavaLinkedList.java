package walmart;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseJavaLinkedList {

    public static void main(String[] args) {
        List<Character> linkedList = new LinkedList<>();
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('c');
        linkedList.add('d');
        List<Character> result = new ReverseJavaLinkedList().reverse(linkedList);
        System.out.println(result);
    }

    private List<Character> reverse(List<Character> linkedList) {
        int size = linkedList.size();
        for (int i = 0; i < size/2; i++) {
            Character first = linkedList.get(i);
            int secondIndex = size - 1 - i;
            Character second = linkedList.get(secondIndex);
            linkedList.set(i, second);
            linkedList.set(secondIndex, first);
        }
        return linkedList;
    }

    private List<Character> reverseWithCollections(List<Character> linkedList) {
        Collections.reverse(linkedList);
        return linkedList;
    }
}
