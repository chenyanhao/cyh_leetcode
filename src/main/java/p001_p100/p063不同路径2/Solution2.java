package p001_p100.p063不同路径2;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        Map<String, Integer> countMap = new HashMap<>();
        return dfs(obstacleGrid, row, col, 0, 0, 0, countMap);
    }

    /**
     * 带备忘录优化的递归，和 dp 等价
     */
    private int dfs(int[][] grid, int row, int col, int i, int j, int res, Map<String, Integer> countMap) {
        if (i == row - 1 && j == col - 1) {
            if (grid[i][j] == 1) {
                return 0;
            }
            return res + 1;
        }

        if (i >= row || j >= col || grid[i][j] == 1) {
            return 0;
        }

        String key1 = (i + 1) + "" + j;
        int r1;
        if (countMap.containsKey(key1)) {
            r1 = countMap.get(key1);
        } else {
            r1 = dfs(grid, row, col, i + 1, j, res, countMap);
            countMap.put(key1, r1);
        }

        String key2 = i + "" + (j + 1);
        int r2;
        if (countMap.containsKey(key2)) {
            r2 = countMap.get(key1);
        } else {
            r2 = dfs(grid, row, col, i, j + 1, res, countMap);
            countMap.put(key2, r2);
        }

        return r1 + r2;
    }

}