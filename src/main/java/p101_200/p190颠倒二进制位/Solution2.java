package p101_200.p190颠倒二进制位;

/**
 * 递归分治
 *
 * 举例说明：以 1 0 1 1 0 1 1 0 为例
 * 左右各取一半，
 *           1 0 1 1
 *                   0 1 1 0
 * 一个左移四位、一个右移四位，
 *                   1 0 1 1
 *           0 1 1 0
 * 执行或运算，
 *           0 1 1 0 1 0 1 1
 *           _______ _______
 *
 * 接下来上面的左右两部分再分别取一半，重复以上操作即可。
 *
 *
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution2 {

    // 每隔一个交换
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101

    // 每隔两个交换
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011

    // 每隔四个交换
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111

    // 每隔八个交换
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits(int n) {
        // Java中，没有无符号整数类型，因此对 n 的右移应使用逻辑右移
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}