package p101_200.p139单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  dp[i]：s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
 *
 *  自底向上 dp，转移方程为，
 *  dp[i] = dp[j] && whether s[j..i-1] in wordDict for j in 0..i-1
 *
 *  其中，判断 dp[j..i-1] 是否在 wordDict 中，可以空间换时间，利用哈希表快速判断
 *  边界条件，定义 dp[0]=true 表示空串且合法。
 *
 *  另外，也可以结合字典树 Trie 来实现，本解法不再展开。
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}