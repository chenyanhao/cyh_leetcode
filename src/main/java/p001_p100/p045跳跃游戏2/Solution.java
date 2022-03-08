package p001_p100.p045跳跃游戏2;

/**
 * 注意：此题是贪心算法，而不是 DP
 *
 * 例如，nums=[2, 3, 1, 1, 4, 1, 1]
 *
 * 1）开始的位置是 2，可跳的范围有 3、1。那么跳到3还是1呢？因为 3 可以跳的更远，所以跳到 3 的位置。
 * 2）现在在位置 3 了，能跳的范围有 1、1、4。因为 4 可以跳的更远，所以这一次跳到 4 的位置。
 * 3）以此类推。
 *
 */
class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        // 左闭右闭区间 [start, end] 表示一次跳跃区间
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            // 求解从start开始，最远能跳到哪里
            int maxPos = 0;
            for (int i = start; i <= end; ++i) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }

            start = end + 1;
            end = maxPos;
            ++ans;
        }

        return ans;
    }
}