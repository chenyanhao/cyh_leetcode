package p101_200.p188买卖股票的最佳时机4;

class Solution2 {


    /**
     *
     * 解法一提交后会提示内存超出限制，原来是传入的 k 值会非常大，dp 数组太大了。这里会优化内存占用。
     *
     * 一次交易由买入和卖出构成，至少需要两天，所以说有效的限制 k 应该不超过 n/2。
     * 如果超过，就没有约束作用了，相当于 k = +inf。也就是说，可以认为 k 和 k - 1 是一样的。
     *
     * 原 dp 方程为，
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 前面已推出来 k 和 k - 1 是一样的，所以也就是说不需要记录 k 这个状态了，所以 dp 方程退化成二维，如下，
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     *
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 空间优化
        if (k > n / 2) {
            return maxProfitKInf(prices);
        }

        int[][][] dp = new int[n][k+1][2];

        /**
         * 初始化 badcase。i-1 == -1 时，由递推公式可知，dp[i-1]没有意义；同理 k-1 == -1 时也是如此。
         * 所以最终循环时，i/k 从 1 开始，i=0/k=0 当做 badcase 初始化
         *
         * dp[i][0][0] = 0; // 第 0 天、不允许交易、未持仓，此时显然总收益为 0
         * dp[i][0][1] = Integer.MIN_VALUE; // 不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能
         *
         * dp[0][k][0] = 0; // 第 0 天、k>=1、未持仓，此时显然总收益为 0
         * dp[0][k][1] = -prices[0]; // 第 0 天、k>=1、已持仓，此时显然是第一天就购入了股票，因此总收益为 -prices[0]
         */
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        for (int kk = 1; kk <= k; ++kk) {
            dp[0][kk][0] = 0;
            dp[0][kk][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; ++i) {
            for (int kk = 1; kk <= k; ++kk) {
                dp[i][kk][0] = Math.max(dp[i-1][kk][0], dp[i-1][kk][1] + prices[i]);
                dp[i][kk][1] = Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    /**
     * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     * dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     */
    private int maxProfitKInf(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                2,4,1
        };
        int res = new Solution2().maxProfit(2, prices);
        System.out.println(res);
    }
}