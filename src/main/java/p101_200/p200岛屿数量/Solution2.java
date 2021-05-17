package p101_200.p200岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 的两个关键地方同 DFS，两个关键地方为，
 * 1）上下左右相邻节点是否合法的判断；
 * 2）如何避免重复遍历。
 */
class Solution2 {

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ++res;
                }
            }
        }

        return res;
    }


    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        while (! queue.isEmpty()) {
            int[] curNode = queue.poll();
            int r = curNode[0], c = curNode[1];

            // badcase。同 DFS
            if (! inArea(grid, r, c)) {
                continue;
            }

            // 如果这个格子不是岛屿，直接返回。同 DFS
            if (grid[r][c] != '1') {
                continue;
            }

            // 将格子标记为已遍历过。同 DFS
            grid[r][c] = '2';

            // 访问上、下、左、右四个相邻结点。同 DFS
            queue.add(new int[] { r - 1, c });
            queue.add(new int[] { r + 1, c });
            queue.add(new int[] { r, c - 1 });
            queue.add(new int[] { r, c + 1 });
        }
    }

    private boolean inArea(char[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length - 1
                && col >= 0 && col <= grid[0].length - 1;
    }
}