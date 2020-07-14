package p032最长有效括号;

import java.util.Arrays;

class Solution {
    /**
     * dp[i]：表示以下标为 i 的字符结尾的最长有效子字符串的长度。
     *
     * if s[i] == '(' :
     *   dp[i] = 0
     * if s[i] == ')' :
     *   if s[i - 1] == '(' :
     *     dp[i] = dp[i - 2] + 2
     *   if s[i - 1] == ')' and s[i - dp[i - 1] - 1] == '(' :
     *     dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     */
    public int longestValidParentheses(String s) {
        int size = s.length();
        int maxLen = 0;
        int[] dp = new int[size];
        Arrays.fill(dp, 0);
        for (int i = 1; i <size; ++i) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 2 - dp[i - 1] >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}