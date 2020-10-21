package p101_200.p132分割回文串2;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * dp[i]：表示前缀子串 s[0:i] 分割成若干个回文子串所需要最小分割次数。
 *
 * dp[i] = min([dp[j] + 1 for j in range(i) if s[j + 1, i] 是回文])
 *
 * 初始状态：单个字符一定是回文串，因此 dp[0] = 0。
 * 结束状态：返回最后一个状态即可，即 dp[len - 1]。
 *
 */
class Solution3 {

    public int minCut(String s) {
        if (s.length() == 1) {
            return 0;
        }

        int[] dp = new int[s.length()];
        // dp 数组初始化
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = i;
        }

        // 构造 dp 数组
        for (int i = 1; i < dp.length; ++i) {
            if (isPalindrome(s, 0, i)) { // 如果 s[0:i] 本身就是一个回文串，那么不用分割
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; ++j) { // 枚举分割点，并求最小
                if (! isPalindrome(s, j + 1, i)) { // [j+1, i] 不是回文串，尝试下一个分割边界。
                    continue;
                }
                dp[i] = Math.min(dp[j] + 1, dp[i]);
            }
        }

        return dp[dp.length - 1];
    }

    /**
     * 判断 [start,end] 是否为回文串，这里的复杂度是 O(N)。
     * 可以利用空间换时间，定义并提前计算好 boolean dp[i][j] 数组，表示 [i,j] 是否为回文串，
     * 这样就可以将判断是否为回文串的复杂度优化到 O(1)
     */
    private boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                ++i;
                --j;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabcbd";
        int res = new Solution3().minCut(s);
        System.out.println(res);
    }



}