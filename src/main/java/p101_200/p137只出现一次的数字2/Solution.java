package p101_200.p137只出现一次的数字2;

import java.util.HashSet;
import java.util.Set;

/**
 * 将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。
 *
 * 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
 *
 * 为了防止溢出，数据格式使用 long 类型
 *
 */
class Solution {
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int n : nums) {
            set.add((long)n);
            sumArray += n;
        }

        for (long n : set) {
            sumSet += n;
        }

        long ans = (3 * sumSet - sumArray) / 2;
        return (int) ans;
    }
}