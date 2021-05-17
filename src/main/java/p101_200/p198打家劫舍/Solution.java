package p101_200.p198打家劫舍;

/**
 * DP 求解。
 * dp[i] 表示前 i 间房屋能偷窃到的最高总金额，
 * 则 dp[i] = max(nums[i] + dp[i-2], dp[i-1])，
 * 其中，
 * dp[0] = nums[0] // 只有一间房，那么直接偷窃
 * dp[1] = max(nums[0], nums[1]) // 只有两间房，那么选择金额较高的偷窃
 *
 * 时间复杂度：O(n)，其中 n 是数组长度。只需要对数组遍历一次。
 *
 * 空间复杂度：O(n)。若使用状态压缩，则空间复杂度为 O(1)。
 *
 */
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; ++i) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[length - 1];
    }
}