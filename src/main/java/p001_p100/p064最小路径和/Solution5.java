package p001_p100.p064最小路径和;

import java.util.HashMap;
import java.util.Map;

/**
 * 将解法二改为备忘录优化
 */
class Solution5 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Map<String, Integer> memo = new HashMap<>();
        return dfs(grid, 0, 0, row, col, 0, memo);
    }

    /**
     * 递归函数定义：从 (i,j) 出发到目的地的最小路径和。入参中 trackSum 不含当前 (i,j) 节点的值。
     *
     * 注意：此处递归变量相当于有三个：i、j、trackSum，改备忘录优化其实没那么直观，更推荐解法三的递归写法。
     *
     * 此写法不方便改备忘录的原因是：
     * 1）递归函数的返回值，含 (i,j) 节点的值；
     * 2）入参 trackSum，不含当前 (i,j) 节点的值。
     *
     * 强行备忘录优化也是可以的，参考本函数写法
     */
    private int dfs(int[][] grid, int i, int j, int row, int col, int trackSum, Map<String, Integer> memo) {
        if (i == row-1 && j == col-1) {
            return trackSum + grid[i][j];
        }

        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }

        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key) + trackSum; // 因为trackSum在下面递归调用时候才加和，所以这里提前返回的话要加上
        }

        int r1 = dfs(grid, i+1, j, row, col, trackSum+grid[i][j], memo);
        int r2 = dfs(grid, i, j+1, row, col, trackSum+grid[i][j], memo);
        memo.put(key, Math.min(r1, r2) - trackSum); // 同理，备忘录的值要减去trackSum
        return Math.min(r1, r2);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = new Solution5().minPathSum(grid);
        System.out.println(ans);
    }
}