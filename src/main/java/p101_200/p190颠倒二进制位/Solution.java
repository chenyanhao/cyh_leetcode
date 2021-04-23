package p101_200.p190颠倒二进制位;

/**
 * 每次把 res 左移，把 n 的二进制末尾数字拼接到结果 res 的末尾；
 * 然后把 n 右移。
 *
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 *
 * 需要注意的是，在某些语言（如Java）中，没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移。
 *
 */
public class Solution {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) { // 本题要求32位整数，位数固定，因此循环 32 次
            res = (res << 1) | (n & 1);
            n = n >>> 1;
        }
        return res;
    }
}