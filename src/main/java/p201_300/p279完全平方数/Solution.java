package p201_300.p279完全平方数;

/**
 * dp[i] 表示 i 的完全平方和的最少数量
 * dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; ++i) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j*j >= 0; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}