package p101_200.p123买卖股票的最佳时机3;

class Solution {
    /**
     * dp[i][k][0 or 1]：第 i 天、第 k 次交易、不持仓 or 持仓
     *
     * dp[i][k][0] = max(rest, sell)
     *             = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(rest, buy)
     *             = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int kMax = 2; // 最多可以完成 2 笔交易
        int[][][] dp = new int[n][kMax+1][2];

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
        for (int k = 1; k <= kMax; ++k) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < n; ++i) {
            for (int k = 1; k <= kMax; ++k) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n - 1][kMax][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                3,3,5,0,0,3,1,4
        };
        int res = new Solution().maxProfit(prices);
        System.out.println(res);
    }

}