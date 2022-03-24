package p101_200.p139单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 采用 dfs，DFS也有两种方式，一个是以 s 为核心，一个是以 wordDict 为核心。
 *
 *  一、以 wordDict。不断穷举 wordDict 中的单词并拼接起来，拼接的字符串不放叫做 s'。看 s' 和 s 是否相等，如果 s' 长度已经大于 s 了就剪枝。
 *      这种方式比较 s' 和 s 两个字符串是否相等将会比较耗时，且没有特别好的方式优化，这种方式时间复杂度肯定下不去。
 *
 *  二、以 s 为核心。不断将 s 拆分为两部分 s1 和 s2，看 s1 和 s2 是否在 wordDict 中。
 *      判断 s1/s2 是否在集合中，可以使用 HashSet 来将时间复杂度优化到 O(1)，所以这种方式更优。本解法就是采用这种方式。
 *
 *
 * 本解法在一些case下会超时，因此可以使用备忘录优化
 */
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, 0, wordSet);
    }

    // s1 = s[start..i]   s2 = s[i+1..length]
    private boolean dfs(String s, int start, Set<String> wordSet) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); ++i) {
            String s1 = s.substring(start, i+1);
            if (! wordSet.contains(s1)) {
                continue;
            }
            if (dfs(s, i+1, wordSet)) {
                return true;
            }
        }
        return false;
    }
}