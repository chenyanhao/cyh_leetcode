package p101_200.p120三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

class Solution5 {

    /**
     * 待备忘录优化的递归，一般都可以转化为 dp 求解。
     * 因此这里使用 dp 求解该问题。本题 dp 又有两种解法：自上而下和自下而上。
     *
     * 自上而下：
     *  dp[i][j] 表示从顶点出发，走到位置 i/j 时的最小路径和（该路径和含 i/j），
     *  那么可以导出递归公式：
     *      普遍情况：dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j]，j < i 且 j != 0
     *      特例1---每一行最左侧的元素：dp[i][0] = dp[i-1][0] + triangle[i][0]，j == 0
     *      特例2---每一行最右侧的元素：dp[i][i] = dp[i-1][i-1] + triangle[i][i]，j == i
     *
     * 自下而上：
     *  dp[i][j] 表示从 i/j 出发，走到底边的最小路径和（该路径和含 i/j），
     *  那么可以导出递归公式：
     *      dp[i][j] = min(dp[i+1][j+1], dp[i+1][j]) + triangle[i][j]
     */
    /**
     * 自下而上 dp 求解
     *      dp[i][j] = min(dp[i+1][j+1], dp[i+1][j]) + triangle[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size+1][size+1];
        for (int i = size - 1; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }




    public static void main(String[] args) {
        int[][] board = new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> triangle = arr2List(board);
        int res = new Solution5().minimumTotal(triangle);
        System.out.println(res);
    }

    private static List<List<Integer>> arr2List(int[][] src) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : src) {
            List<Integer> tmp = new ArrayList<>();
            for (int j : i) {
                tmp.add(j);
            }
            res.add(tmp);
        }
        return res;
    }
}