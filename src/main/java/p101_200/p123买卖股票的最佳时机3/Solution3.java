package p101_200.p123买卖股票的最佳时机3;

class Solution3 {


    /**
     * 利用状态机求解，一共 4 个状态，详见 solution3-plantunl.md。
     * 通过这道题，加深对『状态』和『选择』的理解，以及状态的轮转和选择的关系。
     * 同时还可以跟 dp 状态压缩类比，深刻理解 dp 状态压缩
     *
     * 状态机解释：
     * 一、如果在 state 0，那么有两种选择，rest 或者 buy
     * 1）如果选择 rest，则依然停在 state 0；
     * 2）如果选择 buy，则 spend 当日股票价格的钱后，进入 state 1。
     * 二、如果在 state 1，那么也有两种选择，rest 或者 sell
     * 1）如果选择 rest，则依然停在 state 1；
     * 2）如果选择 sell，则进账当日股价价格的钱后，进入 state 2。
     * 三、state 2、3、4，以此类推。
     *
     * 假设目前处在状态 S，那么状态转移可以写成如下两个公式，
     * S = max(S, X-prices[i]) // 对应 buy
     * S = max(S, X+prices[i]) // 对应 sell
     *
     * 以此思路，可以写出来如下代码。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // s1/s2/s3/s4 分别对应状态机中的状态 1/2/3/4，状态机中的状态 0，当做 init state，不在代码中体现。
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;

        for(int i = 1; i < n; ++i) {
            s1 = Math.max(s1, -prices[i]); // 想到达 state s1，要么停在 s1，要么在初始时购入股票
            // 类比前面解法，这里其实很类似 s2[i] = max(s2[i-1], s1[i-1]+prices[i]) 的 dp 状态压缩版本
            s2 = Math.max(s2, s1 + prices[i]); // 想到达 s2，要么停在 s2，要么在 s1 处执行 sell
            s3 = Math.max(s3, s2 - prices[i]); // s3/s4 以此类推
            s4 = Math.max(s4, s3 + prices[i]);
        }
        return Math.max(0, s4); // 因为 s4 初始化为无穷小，所以这里要取 max
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                3,3,5,0,0,3,1,4
        };
        int res = new Solution3().maxProfit(prices);
        System.out.println(res);
    }

}