package p001_p100.p064最小路径和;

import java.util.HashMap;
import java.util.Map;

/**
 * 带备忘录优化的递归
 */
class Solution4 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Map<String, Integer> memo = new HashMap<>();
        return dfs(grid, 0, 0, row, col, memo);
    }

    /**
     * 递归函数定义：从 (i,j) 出发到目的地的最小路径和
     */
    private int dfs(int[][] grid, int i, int j, int row, int col, Map<String, Integer> memo) {
        if (i == row-1 && j == col-1) {
            return grid[i][j];
        }

        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        // 注意，这里如果写成 String key = i + "" + j，有些case会报错，具体原因不明
        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int r1 = dfs(grid, i+1, j, row, col, memo);
        int r2 = dfs(grid, i, j+1, row, col, memo);
        memo.put(key, grid[i][j] + Math.min(r1, r2));
        return memo.get(key);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = new Solution4().minPathSum(grid);
        System.out.println(ans);
    }
}