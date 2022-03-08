package p001_p100.p055跳跃游戏;


/**
 * 注意：此题是贪心算法，而不是 DP
 *
 * 例如，nums=[2, 3, 1, 1, 4, 1, 1]
 *
 * 1）开始的位置是 2，可跳的范围有 3、1。那么跳到3还是1呢？因为 3 可以跳的更远，所以跳到 3 的位置。
 * 2）现在在位置 3 了，能跳的范围有 1、1、4。因为 4 可以跳的更远，所以这一次跳到 4 的位置。
 * 3）以此类推，看最远的跳跃距离能否超出数组最后一个元素。
 *
 */
class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i <= nums.length-1; ++i) {
            if (i > maxPos) { // 考虑nums=[3, 2, 1, 0, 4]，在循环到i=3时，maxPos也为3，此时跳不到下标为4的位置。这种情况需要提前结束。
                return false;
            }

            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length-1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 0, 4};
        boolean ans = new Solution().canJump(nums);
        System.out.println(ans);
    }
}