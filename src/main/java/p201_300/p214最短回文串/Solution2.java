package p201_300.p214最短回文串;


/**
 * 思路：
 * 求 s 的「最长回文前缀」，然后在 rev_s 的后缀中砍掉这个回文，再加到 s 前面
 *
 * 这就是公共前后缀。KMP 的 next 数组记录的就是一个字符串的每个位置上，最长公共前后缀的长度。
 * 因此，制造出公共前后缀，去套 KMP 算法即可。
 *
 */
class Solution2 {
    public String shortestPalindrome(String s) {
        return null;
    }
}