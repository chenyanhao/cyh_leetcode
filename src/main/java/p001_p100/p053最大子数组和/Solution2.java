package p001_p100.p053最大子数组和;

/**
 * 此题可以延伸，获取最大序列的起始和结束位置
 *
 * 例如，
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6, 3, 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。子数组在原数组中起始位置为 3，终止位置为 6。
 *
 *
 * 解法：也按照解法一的dp思想，dp[i] = max(dp[i-1] + nums[i], nums[i])，
 * 该式子可以换个角度理解：
 * 1）如果dp[i-1] >= 0，说明前面的子数组是正收益，所以保留之前的子数组，此时 dp[i] = dp[i-1] + nums[i]；
 * 2）如果dp[i-1] <  0，说明前面的子数组是负收益，所以不保留，从 nums[i] 重新开始，此时 dp[i] = nums[i]。
 *
 * 用dp方法来找到这个max位置，每次比较最大值的时候更新一下最大值的起始和终止位置
 *
 */
class Solution2 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 以下是需要返回的最优解
        int start = 0, end = 0; // 起始终止位置
        int max = nums[0]; // 全局最大值

        // 以下是循环中迭代的变量
        int subStart = 0, subEnd = 0; // 子数组在原数组中的起始和终止位置
        int subMax = nums[0]; // 前一个子数组的最大值

        for (int i = 1; i < nums.length; ++i) {
            if (subMax >= 0) { // 前一个子数组最大值大于等于0，正收益
                subMax = subMax + nums[i];
                ++subEnd;
            } else { // // 前一个子数组最大值小于0，负收益，所以抛弃前面的结果
                subMax = nums[i];
                subStart = i;
                subEnd = i;
            }

            // 计算全局最大值，并更新最终返回结果
            if (subMax > max) {
                max = subMax;
                start = subStart;
                end = subEnd;
            }
        }

        System.out.println("[" + start + ","+ end +"]");
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[] {2,1,-3,4,1,2,1,-5,4};
        int ans = new Solution2().maxSubArray(nums);
        System.out.println(ans);
    }
}





























