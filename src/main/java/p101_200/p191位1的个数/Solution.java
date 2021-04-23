package p101_200.p191位1的个数;

/**
 * 直接循环检查给定整数 n 的二进制位的每一位是否为 1。
 *
 * 时间复杂度：O(k)，其中 k 是需要检查 n 的二进制位的位数，本题中 k=32。
 * 空间复杂度：O(1)
 *
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & (1 << i)) != 0) {
                ++res;
            }
        }
        return res;
    }
}