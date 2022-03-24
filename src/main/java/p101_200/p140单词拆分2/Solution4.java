package p101_200.p140单词拆分2;

import java.util.*;

/**
 *  dp[i]：s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。
 *
 *  自底向上 dp，转移方程为，
 *  dp[i] = s[j..i-1] join dp[j] if dp[j].size() > 0 && s[j..i-1] in wordDict for j in 0..i-1
 *
 *  其中，判断 dp[j..i-1] 是否在 wordDict 中，可以空间换时间，利用哈希表快速判断
 *  边界条件，定义 dp[0]={""} 表示空串的情况。
 *
 *  这种方式时间空间复杂度都是 O(N^3)，内存会超限。
 *
 *  另外，也可以结合字典树 Trie 来实现，本解法不再展开。
 */
class Solution4 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String>[] dp = new List[s.length() + 1];
        dp[0] = Arrays.asList("");
        for (int i = 1; i <= s.length(); ++i) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                String suffix = s.substring(j, i);
                if (dp[j].size() > 0 && wordSet.contains(suffix)) {
                    for (String prefix : dp[j]) {
                        tmp.add(prefix + (prefix.length() == 0 ? "" : " ") + suffix);
                    }
                }
            }
            dp[i] = tmp;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        String s = "aa";
//        List<String> wordDict = Arrays.asList("a");
        List<String> res = new Solution4().wordBreak(s, wordDict);
        System.out.println(res);
    }
}