package p001_p100.p096不同的二叉搜索树;

import java.util.HashMap;

class Solution2 {

    public int numTrees(int n) {
        return dfs(1, n, new HashMap<>());
    }

    private int dfs(int start, int end, HashMap<String, Integer> memo) {
        if (start > end) {
            return 1; // null 也视为一种二叉搜索树，所以此时需要返回 1，而不是 0
        }

        String key = start + "_" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int totalCnt = 0;
        for (int i = start; i <= end; ++i) {
            int leftCnt = dfs(start, i - 1, memo);
            int rightCnt = dfs(i + 1, end, memo);
            totalCnt += leftCnt * rightCnt;
        }

        memo.put(key, totalCnt);
        return totalCnt;
    }

    public static void main(String[] args) {
        int ans = new Solution2().numTrees(3);
        System.out.println(ans);
    }
}