package p001_p100.p014最长公共前缀;

/**
 * 暴力查找
 *
 * 时间复杂度：O(mn)。 m 为字符串数组中的字符串的平均长度，n 为字符串的数量。
 * 空间复杂度：O(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (String s : strs) {
            prefix = longestPrefix(prefix, s);
            if (prefix.length() == 0) { // 遇到 good case 时，提前终止。
                break;
            }
        }

        return prefix;
    }

    private String longestPrefix(String s1, String s2) {
        int index = 0;
        while (index < s1.length() && index < s2.length() && s1.charAt(index) == s2.charAt(index)) {
            ++index;
        }
        return s1.substring(0, index);
    }
}