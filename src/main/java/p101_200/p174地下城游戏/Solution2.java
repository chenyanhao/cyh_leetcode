package p101_200.p174地下城游戏;

/**
 * 直接递归会超时，这里用备忘录进行优化
 *
 */
class Solution2 {

    private int rowSize;
    private int colSize;
    private int[][] memory;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }
        this.rowSize = dungeon.length;
        this.colSize = dungeon[0].length;

        memory = new int[rowSize][colSize];
        // 初始化为-1，便于区别是否计算过结果了。
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                memory[i][j] = -1;
            }
        }

        return dfs(0, 0, dungeon) + 1;
    }

    private int dfs(int i, int j, int[][] dungeon) {
        if (i >= rowSize || j >= colSize) {
            return Integer.MAX_VALUE;
        }

        // 不为-1就是计算过了，直接返回结果。
        if (memory[i][j] != -1) {
            return memory[i][j];
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
        memory[i][j] = res;
        return res;
    }
}