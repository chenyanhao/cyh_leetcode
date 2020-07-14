package p063不同路径2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; ++i) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int j = 1; j < col; ++j) {
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[row - 1][col - 1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        Map<String, Integer> countMap = new HashMap<>();
        return dfs(obstacleGrid, row, col, 0, 0, 0, countMap);
    }

    private static int dfs(int[][] grid, int row, int col, int i, int j, int res, Map<String, Integer> countMap) {
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

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int i = uniquePathsWithObstacles2(obstacleGrid);
        System.out.println(i);
    }
}