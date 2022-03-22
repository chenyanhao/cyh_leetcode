package p501_600.p516最长回文子序列;

/**
 * dp[i][j]：左闭右闭区间[i,j]范围内，最长回文子序列的长度
 *
 * 1) s[i] == s[j], dp[i][j] = dp[i+1][j-1] + 2
 * 2) s[i] != s[j], dp[i][j] = max(dp[i+1][j], dp[i][j-1])
 *
 * 因为 i 依赖 i+1，所以 i 需要从大到小遍历；j 依赖 j-1，所以 j 需要从小到大遍历。
 *
 * 将dp[i][j]想象成一个二维矩阵，由递推公式可以看出，dp的推导是由左下角往右上角推导的，因此初始化的时候需要初始化左下角及对角线位置元素。
 * 但是考虑到 i 一定是小于 j 的，矩阵左下角不会用到，因此初始化时初始化对角线即可。
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(N^2)
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // DP 初始化对角线，这里初始化的含义是：单个字符也是一个回文串
        for (int i = 0; i < dp.length; ++i) {
            dp[i][i] = 1;
        }

        for (int i = s.length()-1; i >= 0; --i) {
            for (int j = i+1; j < s.length(); ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}