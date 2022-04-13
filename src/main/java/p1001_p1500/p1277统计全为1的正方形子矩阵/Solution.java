package p1001_p1500.p1277统计全为1的正方形子矩阵;

/**
 * 使用动态规划，用 dp[i][j] 表示以(i, j)为右下角的正方形边长最大值。那么 dp[i][j] 也表示以 (i, j) 为右下角的正方形的数目。
 * 所以，在计算出所有的 dp[i][j] 后，将它们进行累加，就可以得到矩阵中正方形的数目。
 *
 * 边界条件：
 * 1) i=0 || j=0，       matrix[i][j]
 * 2) matrix(i, j) = 0， 0
 * 3) otherwise，        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 *
 */
class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }

                ans += dp[i][j];
            }
        }

        return ans;
    }
}