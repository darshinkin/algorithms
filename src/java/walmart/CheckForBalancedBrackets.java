package walmart;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/*
Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

Example:

Input: exp = “[()]{}{[()()]()}”
Output: Balanced

Input: exp = “[(])”
Output: Not Balanced
 */
public class CheckForBalancedBrackets {

    public static void main(String[] args) {
//        String expr = "[()]{}{[()()]()}";
        String expr = "[(])";
        boolean res = new CheckForBalancedBrackets().check(expr);
        System.out.println(res);
    }

    private boolean check(String expr) {
        if (expr.length() < 2) {
            return true;
        }
        Map<Character, Character> map = Map.of('[', ']', '(', ')', '{', '}');
        Character previousElement;
        Stack<Character> stack = new Stack<>();
        char[] chars = expr.toCharArray();
        stack.push(chars[0]);
        for(int i = 1; i < chars.length; ++i) {
            Character currentElement = chars[i];
            try {
                previousElement = stack.peek();
            } catch (EmptyStackException e) {
                stack.push(currentElement);
                continue;
            }
            if (currentElement.equals(map.get(previousElement))) {
                stack.pop();
            } else {
                stack.push(currentElement);
            }
        }
        System.out.println(stack);
        return stack.empty();
    }
}
