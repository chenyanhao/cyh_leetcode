package p101_200.p121买卖股票的最佳时机;

import java.util.ArrayDeque;

class Solution2 {


    /**
     * 用单调栈求解，单调栈的作用：用 O(n) 的时间复杂度求得所有位置两边第一个比他大(或小)的数
     */
    public int maxProfit(int[] prices) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < prices.length; ++i) {
            while (! s.isEmpty() && s.peek() > prices[i]) {
                ans = Math.max(ans, s.peekFirst() - s.peekLast());
                s.pop();
            }
            s.push(prices[i]);
        }

        // 添加哨兵元素，作用就是确保单调栈中的每个元素都被进行判定。
        // 因为单调栈中可能还有残留的元素没有进行判断，所以需要让这些元素都出栈。
        // 比如 prices 数组单调增的情况下，不加哨兵会出现 max=0 的情况。比如 prices=[2, 1, 4] 时，不加哨兵也会出现结果不正确的情况。
        int pivot = -1;
        while (! s.isEmpty() && s.peek() > pivot) {
            ans = Math.max(ans, s.peekFirst() - s.peekLast());
            s.pop();
        }

        return ans;
    }
}