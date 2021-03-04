package p101_200.p174地下城游戏;

/**
 * 带备忘录优化的递归，离 DP 很近了。
 * 这里利用 DP 来求解
 *  needMin + dungeon[i][j] = min(dp[i+1][j], dp[i][j+1])
 *
 * 注意，这里 DP 的方向和前面递归的分析是一致的，是从最后一个(即右下角)开始走。每走一步，出来就记录一下，然后不断复用。
 *
 * 除递推公式外，DP 的另一个核心在于设置起始值，注意值和方向都不要设置错了。
 */
class Solution3 {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 0;
        }

        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int[][] dp = new int[rowSize][colSize];

        // 设置 dp 起点的值，也就是格子最右下角的值
        dp[rowSize - 1][colSize -1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

        // 设置最后一列的值
        for (int i = rowSize - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
            dp[i][colSize -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = colSize - 2; i >= 0; --i) {
            int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
            dp[rowSize - 1][i] = Math.max(0, needMin);
        }


        for (int i = rowSize - 2; i >= 0; --i) {
            for (int j = colSize - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;

    }

}