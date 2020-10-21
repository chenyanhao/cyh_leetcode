package p101_200.p132分割回文串2;


class Solution4 {

    private boolean[][] memo;

    public int minCut(String s) {
        if (s.length() == 1) {
            return 0;
        }

        initMemo(s);

        int[] dp = new int[s.length()];
        // dp 数组初始化
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = i;
        }

        // 构造 dp 数组
        for (int i = 1; i < dp.length; ++i) {
            if (memo[0][i]) { // 如果 s[0:i] 本身就是一个回文串，那么不用分割
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; ++j) { // 枚举分割点，并求最小
                if (! memo[j+1][i]) { // [j+1, i] 不是回文串，尝试下一个分割边界。
                    continue;
                }
                dp[i] = Math.min(dp[j] + 1, dp[i]);
            }
        }

        return dp[dp.length - 1];
    }


    private void initMemo(String s) {
        int len = s.length();
        // 时间换空间，提前计算好 memo 数组
        memo = new boolean[len][len];
        for (int right = 0; right < len; ++right) {
            for (int left = 0; left <= right; ++left) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || memo[left + 1][right - 1])) {
                    memo[left][right] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aabcbd";
        int res = new Solution4().minCut(s);
        System.out.println(res);
    }



}