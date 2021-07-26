package p201_300.p213打家劫舍2;

/**
 * 因为首尾不能连续抢，所以要么抢头不抢尾，要么抢尾不抢头，即要么抢 [0, n-2]，要么抢 [1, n-1]，其中 n 为数组长度
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
    }


    /**
     * [start, end]，左闭右闭区间
     * dp[i] 表示前 i 间房屋能偷窃到的最高总金额，
     * dp[0] = nums[start] // 只有一间房，那么直接偷窃
     * dp[1] = max(nums[start], nums[start+1]) // 只有两间房，那么选择金额较高的偷窃
     */
    private int dp(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);

        for (int i = 2; i < length; ++i) {
            dp[i] = Math.max(dp[i-2] + nums[i+start], dp[i-1]); // nums 下标注意是 i+start，而不是 i
        }

        return dp[length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 1};
        int res = new Solution().rob(nums);
        System.out.println(res);
    }

}