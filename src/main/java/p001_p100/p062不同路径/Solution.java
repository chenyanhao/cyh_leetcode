package p001_p100.p062不同路径;

class Solution {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        return dfs(0, 0, m, n, 0);
    }

    private static int dfs(int i, int j, int row, int col, int res) {
        if (i == row - 1 && j == col - 1) {
            return res + 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        int r1 = dfs(i + 1, j, row, col, res);
        int r2 = dfs(i, j + 1, row, col, res);
        return r1 + r2;
    }



    public static void main(String[] args) {
        int i = uniquePaths2(7, 3);
        System.out.println(i);
    }
}