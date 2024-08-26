package walmart;

import java.util.Stack;

/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
and an additional operation getMin() which should return minimum element from the SpecialStack.
All these operations of SpecialStack must be O(1).
To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc
The interesting part is, how to handle the case when minimum element is removed.
 */
public class StackWithGetMinFunction {

    public static void main(String[] args) {
        CustomizedStack stack = new CustomizedStack();
        stack.push(31);
        stack.push(54);
        stack.push(23);
        stack.push(3);
        printMin(stack);
        stack.pop();
        printMin(stack);
        stack.pop();
        printMin(stack);
        stack.pop();
        printMin(stack);
    }

    private static void printMin(CustomizedStack stack) {
        int res = stack.getMin();
        System.out.println(res);
    }
}

class Node {
    Integer value;
    Integer min;
    public Node(Integer value, Integer min) {
        this.value = value;
        this.min = min;
    }

    public Integer getMin() {
        return min;
    }
}

class CustomizedStack extends Stack<Node> {

    public Integer getMin() {
        return super.peek().getMin();
    }

    public Integer push(Integer item) {
        Integer min;
        if (super.isEmpty()) {
            min = item;
        } else {
            min = super.peek().getMin();
        }
        Node node = new Node(item, Math.min(min, item));
        Node el = super.push(node);
        return el.value;
    }
}