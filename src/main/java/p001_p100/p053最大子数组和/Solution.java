package p001_p100.p053最大子数组和;

class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] --- 以 nums[i] 结尾的最大子序和
        // dp[i] = max(dp[i-1] + nums[i], nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int res = dp[0];
        for (int d : dp) {
            res = Math.max(res, d);
        }

        return res;
    }
}