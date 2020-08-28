package p101_200.p115不同的子序列;

class Solution {

    /**
     * dp[i][j]：s的前 i 个字符（下标0到 i-1）变为t的前 j 个字符（下标0到 j-1），有 dp[i][j] 种方法。
     *
     * 状态转移详解：
     *  s[i-1]==t[j-1]时，计算两类情况的和：
     *     1)保留s[i-1]，有dp[i-1][j-1]种方法。
     *          即：确定s的第i个字符与t的第j个字符对应后，s的前 i-1 个字符有多少种方法变为t的前 j-1 个字符。
     *     2)不保留s[i-1]，有dp[i-1][j]种方法。
     *          即：不使用s的第i个字符，s的前 i-1 个字符有多少种方法变为t的前 j 个字符。
     *     故s[i-1]==t[j-1]时，dp[i][j] = dp[i-1][j-1]+dp[i-1][j]。
     *
     *  s[i-1]!=t[j-1]时，有dp[i-1][j]种方法。
     *      即：已知s的第 i 个字符不能与t的第 j 个字符对应，s的前 i-1 个字符有多少种方法变为t的前 j 个字符
     *
     */
    public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 1; // 从S中选择空字符串T，只需要不选择 S 中的所有字母，所以选法是1
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}