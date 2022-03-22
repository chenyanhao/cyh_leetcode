package p601_700.p647回文子串;

/**
 * dp[i][j]：左闭右闭区间[i,j]的子串是否是回文子串
 *
 * 1) s[i] != s[j], dp[i][j] = false
 * 2) s[i] == s[j]
 *      1. i == j，此时字符串只有一个字符，例如 a，此时当然是回文的；
 *      2. i 与 j 相差等于 1，例如 aa，此时是回文的；
 *      3. i 与 j 相差大于 1，此时要看 dp[i + 1][j - 1] 是否为true。
 *
 * 因为 i 依赖 i+1，所以 i 需要从大到小遍历；j 依赖 j-1，所以 j 需要从小到大遍历。
 *
 * 将dp[i][j]想象成一个二维矩阵，由递推公式可以看出，dp的推导是由左下角往右上角推导的，因此初始化的时候需要初始化左下角及对角线位置元素。
 * 但是考虑到 i 一定是小于 j 的，矩阵左下角不会用到，因此初始化时初始化对角线即可。
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(N^2)
 *
 */
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];
        // DP 初始化对角线，这里相当于是单个字符也是一个回文串，对应上面情况 1
        for (int i = 0; i < dp.length; ++i) {
            dp[i][i] = true;
            ++ans;
        }

        for (int i = s.length()-1; i >= 0; --i) {
            for (int j = i+1; j < s.length(); ++j) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                    continue;
                }

                // 下面这段 if 可以合并下，但是为了突出 dp 递推逻辑，就不做简化了
                if (j - i == 1) { // 情况 2
                    ++ans;
                    dp[i][j] = true;
                } else if (j - i > 1 && dp[i+1][j-1]) { // 情况 3
                    ++ans;
                    dp[i][j] = true;
                }
            }
        }

        return ans;
    }
}