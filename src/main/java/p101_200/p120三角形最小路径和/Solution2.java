package p101_200.p120三角形最小路径和;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    /**
     * 解法 1 中，递归函数有三个变量：i/j/sum，会超时，且由于有 sum，无法进行备忘录优化。
     * 因此这里先对递归变量进行改造，改造为只有 i/j 两个变量，sum 变量作为递归函数的返回值。
     * 此时依然会超时，但这种处理之后就可以进行备忘录优化了。待解法三中用备忘录优化。
     *
     * 递归函数定义为：自顶向下遍历，从第 i 行、第 j 列开始，返回最小路径和（该路径和不包含 i/j 位置的值）
     */
    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        int left = dfs(triangle, i + 1, j);
        int right = dfs(triangle, i + 1, j + 1);
        return Math.min(left, right) + triangle.get(i).get(j);
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        List<List<Integer>> triangle = arr2List(board);
        int res = new Solution2().minimumTotal(triangle);
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