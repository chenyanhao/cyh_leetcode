package p101_200.p200岛屿数量;

class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++res;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        // badcase
        if (! inArea(grid, row, col)) {
            return;
        }

        // 如果这个格子不是岛屿，直接返回
        if (grid[row][col] != '1') {
            return;
        }
        // 将格子标记为已遍历过
        grid[row][col] = '2';

        // 访问上、下、左、右四个相邻结点
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    private boolean inArea(char[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1
                && col >= 0 && col <= grid[0].length - 1;
    }

}