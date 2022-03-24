package p101_200.p137只出现一次的数字2;

import java.util.HashSet;
import java.util.Set;

/**
 * 以 nums=[3, 3, 3, 5] 为例，考查数组每个元素的二进制位，即，
 *
 * 3 = 0 0 1 1
 * 3 = 0 0 1 1
 * 3 = 0 0 1 1
 * 5 = 0 1 0 1
 *
 * 将二进制位按列相加，
 * 得到 0 1 3 4，
 *
 * 对于出现三次的数字，各二进制位出现的次数都是 3 的倍数，因此各位对 3 取余，
 * 得到 0 1 0 1，即为所求。
 *
 */
class Solution2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < 32; ++j) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1; // >>> 是向右移位，高位补零，低位丢弃
            }
        }

        for (int i = 0; i < 32; ++i) {
            count[i] %= 3;
        }

        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res <<= 1; // << 是向左移位，高位丢弃，低位补零
            res |= count[31-i];
        }
        return res;
    }
}