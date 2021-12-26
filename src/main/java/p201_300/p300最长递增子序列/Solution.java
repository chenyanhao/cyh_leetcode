package p201_300.p300最长递增子序列;

import java.util.Arrays;

/**
 * dp[i] 为考虑前 i 个元素，以第 i 个数字结尾(nums[i]必须选)的最长上升子序列的长度
 *
 * dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
 *
 * 时间复杂度 O(N^2)：遍历计算 dp 列表需 O(N)，计算每个 dp[i] 需 O(N)。
 * 空间复杂度 O(N)：dp 列表占用线性大小额外空间。
 *
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < nums.length; ++i) {
            // 计算 dp[i] 时，需要遍历 dp[0…i−1] 的所有状态
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}