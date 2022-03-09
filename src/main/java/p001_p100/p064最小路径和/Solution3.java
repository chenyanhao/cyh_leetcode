package p001_p100.p064最小路径和;

/**
 * 标准递归，解法二的另一种写法，该写法自然也会超时
 */
class Solution3 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return dfs(grid, 0, 0, row, col);
    }

    /**
     * 递归函数定义：从 (i,j) 出发到目的地的最小路径和
     */
    private int dfs(int[][] grid, int i, int j, int row, int col) {
        if (i == row-1 && j == col-1) {
            return grid[i][j];
        }

        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        int r1 = dfs(grid, i+1, j, row, col);
        int r2 = dfs(grid, i, j+1, row, col);
        return grid[i][j] + Math.min(r1, r2);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = new Solution3().minPathSum(grid);
        System.out.println(ans);
    }
}