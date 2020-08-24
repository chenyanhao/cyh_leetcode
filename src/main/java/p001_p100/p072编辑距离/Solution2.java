package p001_p100.p072编辑距离;

import java.util.HashMap;
import java.util.Objects;

class Solution2 {

    private class Pair072 {
        private int x;
        private int y;

        public Pair072(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair072 pair = (Pair072) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    /**
     * 解法 1 中有大量重复路径，是一个重叠子问题的优化，可以用备忘录优化。
     */
    private HashMap<Pair072, Integer> memory = new HashMap<>();
    private int helper(String s1, String s2, int i, int j) {
        Pair072 key = new Pair072(i, j);
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        // badcase
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            int ans = helper(s1, s2, i - 1, j - 1);
            memory.put(key, ans);
            return ans;
        } else {
            int ans = min3(
                    helper(s1, s2, i, j - 1) + 1, // 插入
                    helper(s1, s2, i - 1, j) + 1, // 删除
                    helper(s1, s2, i - 1, j - 1) + 1 // 替换
            );
            memory.put(key, ans);
            return ans;
        }
    }

    // 求 a/b/c 三个数中的最小值
    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}