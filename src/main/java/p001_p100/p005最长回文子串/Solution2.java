package p001_p100.p005最长回文子串;

/**
 *
 * 解法二：利用回文串的特点，从中心开始，不断像两边扩散。
 * 例如，abcba，从最中间 c 为中心，向两边扩散来判断是否是回文串。
 * 那么此时问题转化成了寻找回文中心点的问题。
 *
 * 中心点有两类，
 * 1）单字符。例如 abcd，单字符中心点就有四种：a、b、c、d
 * 2）双字符。例如 abcd，双字符中心点就有三种：ab、bc、cd
 *
 * 因此，长度为 L 的字符串，共有 L 个单字符中心和 L-1 个双字符中心。也就是一共有 2L-1 个中心，所以本解法的外层循环需要循环 2L-1 次。
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 *
 */
class Solution2 {
    public String longestPalindrome(String s) {
        String ans = "";
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < 2*s.length()-1; ++i) {
            // left、right 指针和中心点 i 的下标关系，能兼顾到 i 为奇数或偶数的情况
            int left = i / 2;
            int right = left + i % 2;

            while (left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
                // 更新结果
                String subStr = s.substring(left, right + 1);
                if (subStr.length() > maxLen) {
                    ans = subStr;
                    maxLen = subStr.length();
                }

                --left;
                ++right;
            }
        }

        return ans;
    }


}