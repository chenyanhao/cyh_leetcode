package p101_200.p122买卖股票的最佳时机2;

class Solution {

    /**
     * 贪心算法+双指针
     * 原始问题可以转化为一种贪心策略求解：
     *  找到数组中的所有递增子数组，对每个递增子数组，最末元素和第一个元素的差作为一次收益，将每次收益全部相加即得到总收益
     *
     * 具体找递增子数组的过程，可以用双指针求解，[left, right] 中为递增数组，根据运动条件更新即可。
     *
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int left = 0, right = 0, cur = 0;
        while (cur < prices.length) {
            if (cur+1 < prices.length && prices[cur+1] > prices[cur]) { // 递增，则扩大右区间，即 right 加一
                ++right;
                ++cur;
            } else { // 非递增，则计算该次的收益，同时更新 left/right 指针
                ans += prices[right] - prices[left];
                ++cur;
                left = cur;
                right = cur;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                7,1,5,3,6,4
        };
        int res = new Solution().maxProfit(prices);
        System.out.println(res);
    }
}