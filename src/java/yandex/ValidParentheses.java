package yandex;

import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 */

public class ValidParentheses {

    public static void main(String[] args) {
        String str = "()[]{}";
        boolean result = new ValidParentheses().isValid(str);
        System.out.println(result);
    }

    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of('(', ')', '{', '}', '[' , ']');
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i = 0; i < arr.length; i++) {
            Character cur = arr[i];
            System.out.println("Current char: " + cur);
            Character prev;
            try{
                prev = stack.peek();
            } catch(EmptyStackException ex) {
                stack.push(cur);
                continue;
            }

            if(cur.equals(brackets.get(prev))) {
                stack.pop();
            } else {
                stack.push(cur);
            }

        }
        if(stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
