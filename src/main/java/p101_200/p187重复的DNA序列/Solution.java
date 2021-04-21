package p101_200.p187重复的DNA序列;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 线性时间窗口切片 + HashSet
 *
 * 1) 沿长度为 N 的字符串移动长度为 L 的滑动窗口。
 * 2) 检查滑动窗口中的序列是否在 Hashset 中。
 *  - 如果是，则找到了重复的序列，更新输出。
 *  - 否则，将序列添加到 HashSet 中。
 *
 * 时间复杂度：O((N−L)L)。在执行的循环中，有 N−L+1 个长度为 L 的子字符串。
 * 空间复杂度：使用了 O((N−L)L) 去存储 HashSet，由于 L=10 最终为时间复杂度为 O(N)。
 *
 */
class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        int L = 10;
        for (int i = 0; i < s.length() - L + 1; ++i) {
            String substring = s.substring(i, i + L);
            if (seen.contains(substring)) {
                output.add(substring);
            } else {
                seen.add(substring);
            }
        }
        return new ArrayList<>(output);
    }
}