package p301_400.p438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            // 移动窗口
            char r = s.charAt(right);
            ++right;

            // 入窗口的数据更新
            if (need.containsKey(r)) {
                // 注意：入窗口时，是先更新window，再判断是否更新valid。
                // 出窗口时反过来，是先判断是否更新valid，再更新window。
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).intValue() == need.get(r).intValue()) {
                    ++valid;
                }
            }

            // 当满足条件时，需要进行窗口缩减
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }

                // 移动窗口
                char l = s.charAt(left);
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
        return ans;
    }
}