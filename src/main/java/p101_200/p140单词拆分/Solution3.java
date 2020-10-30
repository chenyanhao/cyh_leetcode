package p101_200.p140单词拆分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 暴力法二：讲原问题转化为一个完全背包问题，wordDict 中每个单词可以使用次数无限，每一步可以从 wordDict 中任取一个单词，直到拼出来字符串 s
 *
 * 这种解法使用 dfs 来实现，有多种条件触发剪枝，以免不必要的递归。假设当前拼成的字符串为 s1，则剪枝条件有，
 * 1）s1.length() > s.lenghth()
 * 2）s.startsWith(s1) == false
 *
 * 和解法一相比，虽然递归少了很多，但是字符串 startsWith() 方法耗时高，所以这种解法也会超时。
 */
class Solution3 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(s, wordDict, new LinkedList<>(), res);
        return res;
    }

    private void dfs(String s, List<String> wordDict, LinkedList<String> path, List<String> res) {
        String s1 = path.stream().collect(Collectors.joining());
        if (s1.length() > s.length()) {
            return;
        }

        if (s1.length() == s.length()) {
            res.add(path.stream().collect(Collectors.joining(" ")));
            return;
        }

        for (String word : wordDict) {
            path.addLast(word);
            String tmp = path.stream().collect(Collectors.joining());
            if (! s.startsWith(tmp)) {
                path.removeLast();
                continue;
            }

            dfs(s, wordDict, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        String s = "aa";
//        List<String> wordDict = Arrays.asList("a");
        List<String> res = new Solution3().wordBreak(s, wordDict);
        System.out.println(res);
    }
}