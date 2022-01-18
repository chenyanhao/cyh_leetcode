package p001_p100.p014最长公共前缀;

import java.util.SortedMap;

/**
 * 二分查找思想。
 * 最长公共前缀的长度不会超过字符串数组中的最短字符串的长度，不妨用 minLength 表示。
 * 则可以在 [0, minLength] 的范围内通过二分查找得到最长公共前缀的长度，步骤为：
 * 1）查找 mid，判断每个字符串的长度为 mid 的前缀是否相同；
 * 2）如果相同则最长公共前缀的长度一定大于或等于 mid；
 * 3）如果不相同则最长公共前缀的长度一定小于 mid；
 * 4）通过上述方式将查找范围缩小一半，直到得到答案。
 *
 * 时间复杂度：O(mn)。m 是字符串数组中的字符串的最小长度，n 是字符串的数量。
 * 二分查找的迭代执行次数是 O(log m)，每次迭代最多需要比较 mn 个字符，因此总时间复杂度是 O(mnlogm)。
 *
 * 空间复杂度：O(1)
 */
class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = strs[0].length();
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }

        int left = 0, right = minLength - 1;
        while (left <= right) {
            int mid = left + (right - right) / 2;
            if (hasCommonPrefix(strs, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return strs[0].substring(0, left);
    }

    private boolean hasCommonPrefix(String[] strs, int index) {
        String base = strs[0].substring(0, index+1);
        for (String s : strs) {
            for (int i = 0; i <= index; ++i) {
                if (s.charAt(i) != base.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        String ans = new Solution2().longestCommonPrefix(strs);
        System.out.println(ans);
    }
}