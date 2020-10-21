package p101_200.p132分割回文串2;

import java.util.LinkedList;

class Solution2 {

    private int minLength = Integer.MAX_VALUE;

    private boolean[][] dp;

    public int minCut(String s) {
        int len = s.length();

        // 时间换空间，提前计算好 dp 数组，这种解法依然会超时，需要继续优化
        dp = new boolean[len][len];
        for (int right = 0; right < len; ++right) {
            for (int left = 0; left <= right; ++left) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        dfs(s, 0, new LinkedList<>());
        return minLength - 1;
    }

    private void dfs(String s, int start, LinkedList<String> path) {
        if (start == s.length()) {
            minLength = Math.min(minLength, path.size());
            return;
        }

        // 当前的长度到达了 min，还是递归没有结束，所以剪枝
        if (path.size() >= minLength) {
            return;
        }

        for (int i = start; i < s.length(); ++i) {
            if (! dp[start][i]) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            dfs(s, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "aabcbd";
        int res = new Solution2().minCut(s);
        System.out.println(res);
    }


}