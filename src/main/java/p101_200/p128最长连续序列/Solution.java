package p101_200.p128最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用 HashSet，空间换时间。
 *
 * 解法一：
 * 枚举数组中的每个数 x，以其为起点，不断尝试匹配 x+1,x+2,⋯ 是否存在，
 * 假设最长匹配到了 x+y，那么以 x 为起点的最长连续序列即为 x,x+1,x+2,⋯,x+y，其长度为 y+1，不断枚举并更新答案即可得到最大。
 * 该解法会从 x 匹配到 x+y，然后 x+1 也匹配到 x+y，这样会有很多重复的匹配。优化这里就得到了解法二，如下，
 *
 *
 * 解法二：
 * 接解法一中的举例 x,x+1,…,x_y，由于要枚举的数 x 一定是在数组中不存在前驱数 x−1 的。
 * 因此可以优化为倒着查 HashSet，即从 x+y 开始，每次在哈希表中检查是否存在 x+y-1，直到找到 x 为止。
 * 不断枚举并更新答案即可得到最大
 *
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        for (int n : nums) {
            if (set.contains(n - 1)) {
                continue;
            }

            int currNum = n;
            int curRes = 1;
            while (set.contains(currNum + 1)) {
                ++currNum;
                ++curRes;
            }

            res = Math.max(res, curRes);

        }

        return res;
    }
}