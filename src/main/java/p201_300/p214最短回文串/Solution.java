package p201_300.p214最短回文串;


/**
 * 暴力法：
 * 将字符串 s 翻转过来，加到 s 的开头。当然这不是最短的，求出来最短的即可。
 *
 * 举例：
 * s = "abcd"
 * rev_s = "dcba"
 * rec_s + s = "dcbaabcd"
 *
 * 去掉一个中间的 a，得到 "dcbabcd"，即最短的回文串
 *
 *
 * s：ananab，rev_s：banana：
 * anana 是回文的，所以 rev_s：banana要砍掉相同的部分（anana），变成 b，再加上去。
 *
 * 所以暴力法就是：求 s 的「最长回文前缀」，然后在 rev_s 的后缀中砍掉这个回文，再加到 s 前面。
 *
 */
class Solution {
    public String shortestPalindrome(String s) {
        return null;
    }
}