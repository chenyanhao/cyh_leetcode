package p501_600.p567字符串的排列;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            // 移动窗口
            char r = s2.charAt(right);
            ++right;

            // 入窗口的数据更新
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).intValue() == need.get(r).intValue()) {
                    ++valid;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                // 移动窗口
                char l = s2.charAt(left);
                ++left;

                // 出窗口的数据更新
                if (need.containsKey(l)) {
                    if (window.get(l).intValue() == need.get(l).intValue()) {
                        --valid;
                    }
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }
        }

        return false;
    }
}