package p101_200.p190颠倒二进制位;

/**
 * 递归分治：
 * 1）把数字分为两半，交换这两半的顺序；
 * 2）把前后两个半段都再分成两半，交换内部顺序；
 * 3）直至最后交换顺序的时候，交换的数字只有 1 位。
 *
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 *
 */
public class Solution2 {

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}