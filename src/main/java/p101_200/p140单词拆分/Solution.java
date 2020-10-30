package p101_200.p140单词拆分;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 暴力法：检查 s 的所有可能前缀是否在字典中，如果在，那么调用回溯函数并检查剩余部分的字符串。
 *
 * 这种解法毫无疑问会超时
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(String s, List<String> wordDict, int start, LinkedList<String> path, List<String> res) {
        if (start == s.length()) {
            String joined = path.stream().collect(Collectors.joining(" "));
            res.add(joined);
            return;
        }

        for (int end = start + 1; end <= s.length(); ++end) {
            String prefix = s.substring(start, end);
            if (! wordDict.contains(prefix)) {
                continue;
            }

            path.addLast(prefix);
            dfs(s, wordDict, end, path, res);
            path.removeLast();
        }
    }

}

