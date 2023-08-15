package epam;

public class GenerateStringWithCharsHaveOddCounts {

    public static void main(String[] args) {
        int n = 7;
        var res = new GenerateStringWithCharsHaveOddCounts().solution(n);
        System.out.println("Result: " + res);
    }

    private String solution(int N) {
        StringBuilder res = new StringBuilder();
        if (N % 2 != 0) {
            for(int i = 0; i < Math.min(N, 24); i++) {
                res.append((char)('b' + i));
            }
            if (N > 24) {
                res.append("a".repeat((N - 24)));
            }
        }
        else {
            for(int i = 0; i < Math.min(N, 25); i++) {
                res.append((char)('b' + i));
            }
            if (N > 25) {
                for(int i = 0;
                    i < (N - 25); i++)
                    res.append('a');
            }
        }
        return res.toString();
    }
}
