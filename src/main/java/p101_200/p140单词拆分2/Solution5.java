package p101_200.p140单词拆分2;

import java.util.*;

/**
 * 通过备忘录，优化解法二。
 *
 * 这里 Recursion + memoization 可以通过，而自下而上的DP则超时。
 * 这说明：自底向上的 DP 不一定比自上而下递归好。
 *  原因是，1）自顶向下方便容易剪支，一些不必要的分支可以提前结束展开计算。
 *  2）而自底向上则不然，需要把所有的可能的情况都要一一列举出来，才能构造更大规模问题的解。
 *
 */
class Solution5 {

    private Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private List<String> dfs(String s, List<String> wordDict, int start) {
        if (start == s.length()) {
            return Arrays.asList("");
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
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

        memo.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        String s = "aa";
//        List<String> wordDict = Arrays.asList("a");
        List<String> res = new Solution5().wordBreak(s, wordDict);
        System.out.println(res);
    }
}