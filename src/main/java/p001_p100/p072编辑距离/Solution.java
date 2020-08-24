package p001_p100.p072编辑距离;

class Solution {

    /**
     * 思路：使用动态规划来求解，伪代码如下，
     * if s1[i] == s2[j]:
     *     啥都别做（skip）
     *     i, j 同时向前移动
     * else:
     *     三选一(全试一遍，哪个操作最后得到的编辑距离最小，就选谁。)：
     *         插入（insert）
     *         删除（delete）
     *         替换（replace）
     *
     */
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int helper(String s1, String s2, int i, int j) {
        // badcase
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return helper(s1, s2, i - 1, j - 1);
        } else {
            return min3(
                    helper(s1, s2, i, j - 1) + 1, // 插入
                    helper(s1, s2, i - 1, j) + 1, // 删除
                    helper(s1, s2, i - 1, j - 1) + 1 // 替换
            );
        }
    }

    // 求 a/b/c 三个数中的最小值
    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}