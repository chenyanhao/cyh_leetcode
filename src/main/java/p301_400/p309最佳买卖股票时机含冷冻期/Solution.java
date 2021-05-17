package p301_400.p309最佳买卖股票时机含冷冻期;

class Solution {

    /**
     * 原 dp 方程为，
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 本题可以无限次地完成交易，即 k=+inf，也就是说，可以认为 k 和 k - 1 是一样的。因此 dp 方程退化成二维，如下，
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     *
     * 最后，本题要求冷冻期为 1 天，因此更改下 dp 方程，得到最终的方程：
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i]) // 第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1
     *
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], 0 - prices[1]);
        for (int i = 2; i < n; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}