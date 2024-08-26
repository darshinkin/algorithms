package cracking.stack;

import java.util.Arrays;
import java.util.Stack;

public class FindNearestWarmerDay {

    public static void main(String[] args)


    {
        int[] days = {6,5,9,8,90,15};
        int[] answers = new FindNearestWarmerDay().solution(days);
        Arrays.stream(answers).forEach(System.out::println);
    }

    private int[] solution(int[] days) {
        Stack<Day> stack = new Stack<>();
        int[] answers = new int[days.length];
        for (int i = days.length-1; i >= 0; i--) {
            if (!stack.empty() && stack.peek().value <= days[i]) {
                stack.pop();
            }
            if (!stack.empty()) {
                answers[i] = stack.peek().index - i;
            }
            stack.push(new Day(days[i], i));
        }
        return answers;
    }

    static class Day {
        int value;
        int index;

        private Day(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
