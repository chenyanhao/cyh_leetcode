package p101_200.p152乘积最大子数组;

/**
 * 根据符号的个数
 *  1) 当负数个数为偶数时候，全部相乘一定最大
 *  2) 当负数个数为奇数时候，它的左右两边的负数个数一定为偶数，只需求两边最大值
 *  3) 当有 0 情况，重置就可以了
 *
 */
class Solution2 {
    /**
     * 首先，如果数组中没有0的话，那么拥有最大乘积的子数组一定以原数组的第一个元素开始（前缀数组）,
     * 或者以原数组的最后一个元素结尾（后缀数组）。
     * 所以，分别计算前缀乘积数组和后缀乘积数组，数组 nums 和 reverseNums，然后返回两个数组中的最大值即可。
     */
    public int maxProduct(int[] nums) {
        int[] reverseNums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            reverseNums[i] = nums[nums.length - i - 1];
        }

        for (int i = 1; i < nums.length; ++i) {
            nums[i] *= nums[i - 1] != 0 ? nums[i - 1] : 1;
            reverseNums[i] *= reverseNums[i - 1] != 0 ? reverseNums[i - 1] : 1;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            ans = Math.max(ans, Math.max(nums[i], reverseNums[i]));
        }

        return ans;
    }
}