package p001_p100.p072编辑距离;

class Solution3 {

    /**
     * 思路：使用动态规划来求解，伪代码如下，
     * if s1[i] == s2[j]:
     *     啥都别做（skip）
     *     i, j 同时向前移动
     * else:
     *     三选一(全试一遍，哪个操作最后得到的编辑距离最小，就选谁。)：
     *         插入（insert）
     *         删除（delete）
     *         替换（replace）
     *
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // badcase
        // 当 word 2 长度为 0 时，将 word1 的全部删除
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        // 当 word1 长度为 0 时，就插入所有 word2 的字符
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }

                dp[i + 1][j + 1] = min3(dp[i][j + 1] + 1, dp[i + 1][j] + 1, dp[i][j] + 1);
            }
        }
        return dp[m][n];
    }

    // 求 a/b/c 三个数中的最小值
    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}