package p101_200.p139单词拆分;

import java.util.*;

/**
 * 使用备忘录优化解法二
 */
class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, 0, wordSet, new HashMap<>());
    }

    // s1 = s[start..i]   s2 = s[i+1..length]
    private boolean dfs(String s, int start, Set<String> wordSet, Map<String, Boolean> memo) {
        if (start == s.length()) {
            return true;
        }

        String key = String.valueOf(start);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i = start; i < s.length(); ++i) {
            String s1 = s.substring(start, i+1);
            if (! wordSet.contains(s1)) {
                continue;
            }
            if (dfs(s, i+1, wordSet, memo)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}