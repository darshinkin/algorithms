package dinamyc;

public class FindNumberOfWays {

    public static void main(String[] args) {
        new FindNumberOfWays().paths(3, 1);
    }

    private int paths(int n, int m) {
        /*if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 && m == 1) {
            return 1;
        }
        return paths(n -1, m) + paths(n, m -1);*/
        return helper(n, m, new int[n+1][m+1]);
    }

    private int helper(int n, int m, int[][] arr) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 && m == 1) {
            return 1;
        }
        if (arr[n][m] != 0) {
            return arr[n][m];
        }
        arr[n][m] = helper(n-1,m,arr) + helper(n, m-1, arr);
        return arr[n][m];
    }
}
