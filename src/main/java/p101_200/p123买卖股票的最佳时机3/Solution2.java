package p101_200.p123买卖股票的最佳时机3;

class Solution2 {

    /**
     * 解法一中，采用的是最通用的做法，对于该题，k=2，k 维的规模较小，可以穷举出来，因此可以进一步优化空间和时间复杂度。
     *
     * dp[i][k][0] = max(rest, sell)
     *             = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(rest, buy)
     *             = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *
     * 穷举 k=1/2 的情况，得到
     * dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     * dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     *
     * dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     * dp[i][1][1] = max(dp[i-1][1][1], 0 - prices[i])
     *
     */
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }
        return dp_i20;
    }

    /**
     * 注意和上面方法对比细节：
     * 这里 dp_i11/dp_i21 初始化的数值和解法一相同，同时下面的 for 循环从 1 开始
     */
    public int maxProfit2(int[] prices) {
        int dp_i10 = 0, dp_i11 = -prices[0]; // 注意对比这里细节
        int dp_i20 = 0, dp_i21 = -prices[0]; // 注意对比这里细节
        for (int i = 1; i < prices.length; ++i) { // 注意对比这里细节
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }
        return dp_i20;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                3,3,5,0,0,3,1,4
        };
        int res = new Solution2().maxProfit(prices);
        System.out.println(res);
    }

}