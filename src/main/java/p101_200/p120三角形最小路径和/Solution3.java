package p101_200.p120三角形最小路径和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution3 {

    private Map<String, Integer> memo = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    /**
     * 解法二会超时，这里进行备忘录优化。
     *
     * 递归函数定义为：自顶向下遍历，从第 i 行、第 j 列开始，返回最小路径和（该路径和不包含 i/j 位置的值）
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        String key = i + "#" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int left = dfs(triangle, i + 1, j);
        int right = dfs(triangle, i + 1, j + 1);
        int res = Math.min(left, right) + triangle.get(i).get(j);
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> triangle = arr2List(board);
        int res = new Solution3().minimumTotal(triangle);
        System.out.println(res);
    }

    private static List<List<Integer>> arr2List(int[][] src) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : src) {
            List<Integer> tmp = new ArrayList<>();
            for (int j : i) {
                tmp.add(j);
            }
            res.add(tmp);
        }
        return res;
    }
}