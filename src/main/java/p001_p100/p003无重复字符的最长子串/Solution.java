package p001_p100.p003无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 滑动窗口，[left, right] 左闭右闭
    // 同时利用 hashmap 节省左边界的查找并收缩的时间
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        // 记录窗口中的字符出现的次数
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            count.put(c1, count.getOrDefault(c1, 0) + 1);
            ++right;

            // 如果 window 中出现重复字符
            // 开始移动 left 缩小窗口
            while (count.get(c1) > 1) {
                char c2 = s.charAt(left);
                count.put(c2, count.get(c2) - 1);
                ++left;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}