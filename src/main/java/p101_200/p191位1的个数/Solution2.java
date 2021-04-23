package p101_200.p191位1的个数;

/**
 * 经典解法：n & (n−1)
 *
 * 时间复杂度：O(logn)，循环次数等于 n 的二进制位中 1 的个数，最坏情况下 n 的二进制位全部为 1，此时需要循环 logn 次。
 * 空间复杂度：O(1)
 *
 */
public class Solution2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            ++res;
        }
        return res;
    }
}