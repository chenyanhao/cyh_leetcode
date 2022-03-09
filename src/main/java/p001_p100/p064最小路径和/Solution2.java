package p001_p100.p064最小路径和;

/**
 * 标准递归，此种解法会超时
 */
class Solution2 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return dfs(grid, 0, 0, row, col, 0);
    }

    /**
     * 递归函数定义：从 (i,j) 出发到目的地的最小路径和。入参中 trackSum 不含当前 (i,j) 节点的值。
     *
     * 注意：此处递归变量相当于有三个：i、j、trackSum，不方便后面改成备忘录优化。所以解法三回解决这个问题，方便解法四改为备忘录优化
     *
     * 此解法不方便改备忘录的原因是：
     * 1）递归函数的返回值，含 (i,j) 节点的值；
     * 2）入参 trackSum，不含当前 (i,j) 节点的值。
     *
     * 如果非要用此种思路改为备忘录的话，参照解法五。
     *
     */
    private int dfs(int[][] grid, int i, int j, int row, int col, int trackSum) {
        if (i == row-1 && j == col-1) {
            return trackSum + grid[i][j];
        }

        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        int r1 = dfs(grid, i+1, j, row, col, trackSum+grid[i][j]);
        int r2 = dfs(grid, i, j+1, row, col, trackSum+grid[i][j]);
        return Math.min(r1, r2);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = new Solution2().minPathSum(grid);
        System.out.println(ans);
    }
}