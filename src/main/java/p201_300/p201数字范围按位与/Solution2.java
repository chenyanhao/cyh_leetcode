package p201_300.p201数字范围按位与;

/**
 * 以 left=9, right=12 为例，
 *
 * 9        0 0 0 0 1 0 0 1
 * 10       0 0 0 0 1 0 1 0
 * 11       0 0 0 0 1 0 1 1
 * 12       0 0 0 0 1 1 0 0
 * result   0 0 0 0 1 0 0 0
 *
 * 考虑到按位与运算的性质，对于一系列的位，只要有一个零值的位，那么这一系列位的按位与运算结果都将为零。
 * 从例子中可以发现，对所有数字执行按位与运算的结果，是所有对应二进制字符串的公共前缀，再用零补上后面的剩余位。
 * 所以问题转化为：给定两个整数，找到它们对应的二进制字符串的公共前缀。
 *
 * 解法二：Brian Kernighan 算法
 * 对 number 和 number−1 进行按位与运算后，number 中最右边的 1 会被抹去变成 0。
 *
 *
 * 以 number=12 为例，
 *  number=12      0 0 0 0 1 1 0 0
 *  number-1=11    0 0 0 0 1 0 1 1
 * 按位与运算后，得到 0 0 0 0 1 0 0 0
 *
 * 时间复杂度：O(log_right)。因为 left < right，时间复杂度取决于 right 的二进制位数。
 * 空间复杂度：O(1)。只需要常数空间。
 *
 */
class Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}