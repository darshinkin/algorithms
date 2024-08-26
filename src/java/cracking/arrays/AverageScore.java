package cracking.arrays;

public class AverageScore {
    public static void main(String[] args) {
        String[][] input = new String[][]{{"Ivan", "33"}, {"Eva", "66"}};
        int res = new AverageScore().solution(input);
        System.out.println(res);
    }

    private int solution(String[][] input) {
        for (int i = 1; i < input.length; i++) {
            String s = input[i][0];
        }

        return 0;
    }
}
