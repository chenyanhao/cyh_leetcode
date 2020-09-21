package p101_200.p121买卖股票的最佳时机;

class Solution {

    /**
     * 一次遍历解决问题，遍历过程中，minPrice 记录下来最小的买入价，同时 ans 记录下来最大的差价，即利润即可。
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;
    }
}