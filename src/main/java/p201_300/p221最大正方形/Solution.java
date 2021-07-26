package p201_300.p221最大正方形;

/**
 * 使用动态规划，用 dp[i][j] 表示以(i, j)为右下角，且只包含 1 的正方形的边长最大值。
 * 本题要求面积，正方形边长的平方即为面积。
 *
 * 则 dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 *
 * 边界条件：
 * 如果 i 和 j 中至少有一个为 0，则以(i, j)为右下角的最大正方形的边长只能是1，此时 dp(i,j)=1。
 *
 *
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}