package p101_200.p115不同的子序列;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

    private Map<String, Integer> countMap = new HashMap<>();

    /**
     * 递归解法，同时用备忘录优化
     */
    public int numDistinct(String s, String t) {
        return dfs(s, 0, t, 0);
    }

    private int dfs(String s, int sStart, String t, int tStart) {

        //T 是空串，选法就是 1 种
        if (tStart == t.length()) {
            return 1;
        }
        //S 是空串，选法是 0 种
        if (sStart == s.length()) {
            return 0;
        }

        String key = sStart + "@" + tStart;
        if (countMap.containsKey(key)) {
            return countMap.get(key);
        }

        int count = 0;
        if (s.charAt(sStart) == t.charAt(tStart)) {
            // 从 S 选择当前的字母，此时 S 跳过这个字母, T 也跳过一个字母。
            count = dfs(s, sStart + 1, t, tStart + 1)
                    // S 不选当前的字母，此时 S 跳过这个字母，T 不跳过字母。
                    + dfs(s, sStart + 1, t, tStart);

        } else {
            //S 只能不选当前的字母，此时 S 跳过这个字母， T 不跳过字母。
            count = dfs(s, sStart + 1, t, tStart);
        }

        countMap.put(key, count);
        return count;
    }
}