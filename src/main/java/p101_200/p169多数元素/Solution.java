package p101_200.p169多数元素;

/**
 * 采用摩尔投票法
 *  1) 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
 *  2) 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
 *  3) 当票数count为0时，更换候选人，并将票数count重置为1。
 *  4) 遍历完数组后，cand_num即为最终答案。
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
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}