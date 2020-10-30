package p101_200.p140单词拆分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解法一中的 dfs 方法也可以写成这种带返回值的形式，因为下面这种写法方便后面改造成备忘录优化的形式。
 */
class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private List<String> dfs(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return Arrays.asList("");
        }

        List<String> res = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); ++end) {
            String prefix = s.substring(start, end);
            if (! wordDict.contains(prefix)) {
                continue;
            }

            List<String> suffixes = dfs(s, wordDict, end);
            for (String suffix : suffixes) {
                res.add(suffix.length() == 0 ? prefix : prefix + " " + suffix);
            }
        }
        return res;
    }

}