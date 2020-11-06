package p101_200.p152乘积最大子数组;

import java.util.Arrays;

/**
 * dp[i] 表示 i 结尾的最大数组乘积
 *
 * 错误解法：dp[i] = max(dp[i-1] * a[i], a[i])
 * 注意这里的定义并不满足「最优子结构」，反例，a={5,6,−3,4,−3}，那么此时 dp 数组为 {5,30,−3,4,−3}。原因是数组中可能有负数。
 *
 * 正确解法：
 * 考虑当前位置的正负，
 *  1）当前位置为负：那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，并且希望这个积尽可能「负得更多」，即尽可能小。
 *  2）当前位置为正：同理，更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
 * 所以还需要维护一个 dp 数组，来记录尽可能小的积。
 *
 * 因此一共维护两个 dp 数组，分别为 dp1 dp2，分别记录尽可能大和尽可能小的积。
 *
 * dp1[i] = max(dp1[i-1] * a[i], dp2[i-1] * a[i], a[i])
 * dp2[i] = min(dp2[i-1] * a[i], dp1[i-1] * a[i], a[i])
 *
 */
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dp1 = Arrays.copyOf(nums, length);
        int[] dp2 = Arrays.copyOf(nums, length);

        for (int i = 1; i < length; ++i) {
            dp1[i] = Math.max(dp1[i-1] * nums[i], Math.max(dp2[i-1] * nums[i], nums[i]));
            dp2[i] = Math.min(dp2[i-1] * nums[i], Math.min(dp1[i-1] * nums[i], nums[i]));
        }

        int ans = dp1[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, dp1[i]);
        }

        return ans;
    }
}