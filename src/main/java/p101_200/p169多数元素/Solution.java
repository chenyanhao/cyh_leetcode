package p101_200.p169多数元素;

/**
 * 采用摩尔投票法
 *
 * 为何这行得通呢？
 * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
 * 且多数元素的个数 > n/2，其余元素的个数总和 <= n/2。
 * 因此多数元素的个数 - 其余元素的个数总和 一定 >= 1。
 * 相当于每个多数元素和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个多数元素。
 *
 * 时间复杂度 O(n)，空间复杂度 O(1)。
 * 求 众数 的题目都可以采用摩尔投票法的思想。
 *
 */
class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0, count = 0;
        for (int n : nums) {
            if (count > 0 && cand == n) { // 是当前候选者
                ++count;
            } else if (count == 0) { // 还没有候选者，或者之前次数已经归零了
                cand = n;
                count = 1;
            } else { // 不是当前候选者
                --count;
            }
        }

        return cand;
    }
}