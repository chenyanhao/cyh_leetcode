package p101_200.p120三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int ans = Integer.MAX_VALUE;

    /**
     * 使用 dfs 处理，这种做法会超时
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> triangle, int i, int j, Integer sum) {
        if (i == triangle.size()) {
            ans = Math.min(ans, sum);
            return;
        }

        List<Integer> selections = triangle.get(i);
        dfs(triangle, i + 1, j, sum + selections.get(j));
        if (j + 1 <= selections.size() - 1) {
            dfs(triangle, i + 1, j + 1, sum + selections.get(j + 1));
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> triangle = arr2List(board);
        int res = new Solution().minimumTotal(triangle);
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