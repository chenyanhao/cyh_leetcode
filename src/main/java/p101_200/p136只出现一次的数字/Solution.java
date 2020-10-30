package p101_200.p136只出现一次的数字;

/**
 * 任何数和其自身做异或运算，结果是 0；
 * 任何数和 0 做异或运算，结果仍然是原来的数。
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}