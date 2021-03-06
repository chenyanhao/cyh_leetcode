package p101_200.p174地下城游戏;

/**
 * 递归求解，f(i, j) 表示到达 (i, j) 且能或者走出去所需要的临界血量(临界血量可以为0)，则递推关系如下，
 *
 * 从 (i,j) 的右边、下边，两者之中选择一个耗费生命较小的，然后算是 (i,j) 本身这个格子所需要的血量，就是最小的血量了。
 *
 *  f(i, j) + dungeon[i][j] = min(f(i+1, j), f(i, j+1))
 * 注意，递推关系是由 i+1/j+1 推导到 i/j 的，只能"倒着推"；因为无法从 i-1/j-1 推导到 i/j
 *
 * 当然了，f(i, j) 是临界值，因此要确保骑士活着，要在 f(i, j) 上加 1 才是骑士的最低血量。
 *
 */
class Solution {

    private int rowSize;
    private int colSize;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        this.rowSize = dungeon.length;
        this.colSize = dungeon[0].length;

        return dfs(0, 0, dungeon) + 1;
    }

    private int dfs(int i, int j, int[][] dungeon) {
        if (i >= rowSize || j >= colSize) {
            return Integer.MAX_VALUE;
        }

        if (i == rowSize - 1 && j == colSize - 1) {
            if (dungeon[i][j] >= 0) {
                return 0;
            } else {
                return -dungeon[i][j];
            }
        }

        // 右边格子的最优解
        int rightMin = dfs(i, j+1, dungeon);
        // 下边格子的最优解
        int downMin = dfs(i+1, j, dungeon);

        // f(i,j) = min(f(i+1, j), f(i, j+1)) - dungeon[i][j]
        int needMin = Math.min(rightMin, downMin) - dungeon[i][j];
        int res = Math.max(0, needMin);
        // System.out.println(i + " " + j + " " + res); // 查看是否有大量重复的递归路径，方面后面备忘录优化
        return res;
    }
}